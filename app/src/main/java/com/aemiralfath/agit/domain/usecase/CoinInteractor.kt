package com.aemiralfath.agit.domain.usecase

import com.aemiralfath.agit.data.Resource
import com.aemiralfath.agit.domain.model.Coin
import com.aemiralfath.agit.domain.repository.ICoinRepository
import kotlinx.coroutines.flow.Flow

class CoinInteractor(private val coinRepository: ICoinRepository) : CoinUseCase {

    override fun getAllCoin(): Flow<Resource<List<Coin>>> = coinRepository.getAllCoin()

    override fun getFavoriteCoin(): Flow<List<Coin>> = coinRepository.getFavoriteCoin()

    override fun setFavoriteCoin(coin: Coin, state: Boolean) =
        coinRepository.setFavoriteCoin(coin, state)

}