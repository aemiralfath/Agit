package com.aemiralfath.agit.data.source.remote

import android.util.Log
import com.aemiralfath.agit.data.source.remote.network.ApiResponse
import com.aemiralfath.agit.data.source.remote.network.ApiService
import com.aemiralfath.agit.data.source.remote.response.CoinResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService: ApiService) {

    suspend fun getListCrypto(
        limit: Int,
        tysm: String = "USD"
    ): Flow<ApiResponse<List<CoinResponse>>> {
        return flow {
            try {
                val response = apiService.getListCrypto(limit, tysm)
                val data = response.data

                if (data.isNullOrEmpty()) {
                    emit(ApiResponse.Empty)
                } else {
                    emit(ApiResponse.Success(data))
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

}