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
    val blockTime: Int,
    val maxSupply: Int,
    val netHashesPerSecond: Int,
    val blockNumber: Int,
    val blockReward: Int,
    var isFavorite: Boolean
) : Parcelable
