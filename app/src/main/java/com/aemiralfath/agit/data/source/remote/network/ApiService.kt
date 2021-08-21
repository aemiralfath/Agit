package com.aemiralfath.agit.data.source.remote.network

import com.aemiralfath.agit.data.source.remote.response.CryptoResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/data/top/totaltoptiervolfull")
    suspend fun getListCrypto(
        @Query("limit") limit: Int,
        @Query("tysm") tysm: String
    ): CryptoResponse

}