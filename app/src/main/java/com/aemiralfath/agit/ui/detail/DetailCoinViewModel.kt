package com.aemiralfath.agit.ui.detail

import androidx.lifecycle.ViewModel
import com.aemiralfath.agit.domain.model.Coin
import com.aemiralfath.agit.domain.usecase.CoinUseCase

class DetailCoinViewModel(private val coinUseCase: CoinUseCase) : ViewModel() {
    fun setFavoriteCoin(coin: Coin, newStatus: Boolean) =
        coinUseCase.setFavoriteCoin(coin, newStatus)
}