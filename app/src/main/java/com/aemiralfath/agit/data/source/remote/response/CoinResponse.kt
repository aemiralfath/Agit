package com.aemiralfath.agit.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class CoinResponse(

    @field:SerializedName("CoinInfo")
    val coinInfo: CoinInfo? = null
)

data class CoinInfo(

    @field:SerializedName("Id")
    val id: String? = null,

    @field:SerializedName("Name")
    val name: String? = null,

    @field:SerializedName("FullName")
    val fullName: String? = null,

    @field:SerializedName("AssetLaunchDate")
    val assetLaunchDate: String? = null,

    @field:SerializedName("ImageUrl")
    val imageUrl: String? = null,

    @field:SerializedName("Algorithm")
    val algorithm: String? = null,

    @field:SerializedName("Url")
    val url: String? = null,

    @field:SerializedName("BlockTime")
    val blockTime: Double? = null,

    @field:SerializedName("MaxSupply")
    val maxSupply: Double? = null,

    @field:SerializedName("BlockNumber")
    val blockNumber: Double? = null,

    @field:SerializedName("BlockReward")
    val blockReward: Double? = null,

    @field:SerializedName("DocumentType")
    val documentType: String? = null,

    @field:SerializedName("ProofType")
    val proofType: String? = null,

    @field:SerializedName("Type")
    val type: Int? = null,

    @field:SerializedName("Internal")
    val internal: String? = null
)