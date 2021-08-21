package com.aemiralfath.agit.di

import com.aemiralfath.agit.domain.usecase.CoinInteractor
import com.aemiralfath.agit.domain.usecase.CoinUseCase
import com.aemiralfath.agit.ui.detail.DetailCoinViewModel
import com.aemiralfath.agit.ui.favorite.FavoriteViewModel
import com.aemiralfath.agit.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<CoinUseCase> { CoinInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { FavoriteViewModel(get()) }
    viewModel { DetailCoinViewModel(get()) }
}