package com.aemiralfath.agit.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class CoinResponse(
    @field:SerializedName("CoinInfo")
    val coinInfo: CoinInfoResponse? = null
)