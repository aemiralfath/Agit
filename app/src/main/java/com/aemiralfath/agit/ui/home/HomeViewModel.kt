package com.aemiralfath.agit.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.aemiralfath.agit.data.Resource
import com.aemiralfath.agit.domain.model.Coin
import com.aemiralfath.agit.domain.usecase.CoinUseCase

class HomeViewModel(coinUseCase: CoinUseCase) : ViewModel() {

    private val coin = coinUseCase

    fun setCoin(): LiveData<Resource<List<Coin>>> = coin.getAllCoin().asLiveData()

}