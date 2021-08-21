package com.aemiralfath.agit.domain.repository

import com.aemiralfath.agit.data.Resource
import com.aemiralfath.agit.domain.model.Coin
import kotlinx.coroutines.flow.Flow

interface ICoinRepository {

    fun getAllCoin(): Flow<Resource<List<Coin>>>

    fun getFavoriteCoin(): Flow<List<Coin>>

    fun setFavoriteCoin(coin: Coin, state: Boolean)

}