package com.aemiralfath.agit.data.source.local

import com.aemiralfath.agit.data.source.local.entity.CoinEntity
import com.aemiralfath.agit.data.source.local.room.CoinDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val coinDao: CoinDao) {

    fun getAllCoin(): Flow<List<CoinEntity>> = coinDao.getAllCoin()

    fun getFavoriteCoin(): Flow<List<CoinEntity>> = coinDao.getFavoriteCoin()

    suspend fun insertCoin(coinList: List<CoinEntity>) = coinDao.insertCoin(coinList)

    fun setFavoriteCoin(coin: CoinEntity, newState: Boolean) {
        coin.isFavorite = newState
        coinDao.updateFavoriteCoin(coin)
    }

}