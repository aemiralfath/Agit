package com.aemiralfath.agit.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.aemiralfath.agit.domain.model.Coin
import com.aemiralfath.agit.domain.usecase.CoinUseCase

class FavoriteViewModel(coinUseCase: CoinUseCase) : ViewModel() {

    private val coin = coinUseCase

    fun setFavoriteCoin(): LiveData<List<Coin>> = coin.getFavoriteCoin().asLiveData()

}