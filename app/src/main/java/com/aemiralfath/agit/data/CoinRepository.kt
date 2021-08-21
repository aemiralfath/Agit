package com.aemiralfath.agit.data

import com.aemiralfath.agit.data.source.local.LocalDataSource
import com.aemiralfath.agit.data.source.remote.RemoteDataSource
import com.aemiralfath.agit.data.source.remote.network.ApiResponse
import com.aemiralfath.agit.data.source.remote.response.CoinResponse
import com.aemiralfath.agit.domain.model.Coin
import com.aemiralfath.agit.domain.repository.ICoinRepository
import com.aemiralfath.agit.utils.AppExecutors
import com.aemiralfath.agit.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CoinRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : ICoinRepository {
    override fun getAllCoin(): Flow<Resource<List<Coin>>> =
        object : NetworkBoundResource<List<Coin>, List<CoinResponse>>() {
            override fun loadFromDB(): Flow<List<Coin>> =
                localDataSource.getAllCoin().map { DataMapper.mapEntitiesToDomain(it) }

            override fun shouldFetch(data: List<Coin>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<CoinResponse>>> =
                remoteDataSource.getListCrypto(30)

            override suspend fun saveCallResult(data: List<CoinResponse>) {
                val coinList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertCoin(coinList)
            }
        }.asFlow()

    override fun getFavoriteCoin(): Flow<List<Coin>> {
        return localDataSource.getFavoriteCoin().map { DataMapper.mapEntitiesToDomain(it) }
    }

    override fun setFavoriteCoin(coin: Coin, state: Boolean) {
        val coinEntity = DataMapper.mapDomainToEntity(coin)
        appExecutors.diskIO().execute {
            localDataSource.setFavoriteCoin(coinEntity, state)
        }
    }
}