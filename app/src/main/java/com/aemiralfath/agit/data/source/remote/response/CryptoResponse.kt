package com.aemiralfath.agit.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class CryptoResponse(

    @field:SerializedName("Message")
    val message: String? = null,

    @field:SerializedName("Data")
    val data: List<CoinResponse>? = null,
)
