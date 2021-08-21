package com.aemiralfath.agit.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Coin(
    var id: String,
    var name: String,
    var fullName: String,
    val date: String,
    val imageUrl: String,
    val algorithm: String,
    val url: String,
    val blockTime: Double,
    val maxSupply: Double,
    val blockNumber: Double,
    val blockReward: Double,
    var isFavorite: Boolean
) : Parcelable
