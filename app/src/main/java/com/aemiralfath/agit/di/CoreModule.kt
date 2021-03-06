package com.aemiralfath.agit.di

import androidx.room.Room
import com.aemiralfath.agit.BuildConfig
import com.aemiralfath.agit.data.CoinRepository
import com.aemiralfath.agit.data.source.local.LocalDataSource
import com.aemiralfath.agit.data.source.local.room.CoinDatabase
import com.aemiralfath.agit.data.source.remote.RemoteDataSource
import com.aemiralfath.agit.data.source.remote.network.ApiService
import com.aemiralfath.agit.domain.repository.ICoinRepository
import com.aemiralfath.agit.utils.AppExecutors
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val databaseModule = module {
    factory { get<CoinDatabase>().coinDao() }
    single {
        Room.databaseBuilder(
            androidContext(),
            CoinDatabase::class.java, "Crypto.db"
        ).fallbackToDestructiveMigration()
            .build()
    }
}

val networkModule = module {
    single {
        if (BuildConfig.DEBUG) {
            OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .connectTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .build()
        } else {
            OkHttpClient()
        }
    }

    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://min-api.cryptocompare.com")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()

        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    factory { AppExecutors() }
    single<ICoinRepository> { CoinRepository(get(), get(), get()) }
}