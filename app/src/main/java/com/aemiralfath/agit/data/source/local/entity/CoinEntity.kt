package com.aemiralfath.agit.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "coin")
data class CoinEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    var id: String,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "fullName")
    var fullName: String,

    @ColumnInfo(name = "date")
    val date: String,

    @ColumnInfo(name = "imageUrl")
    val imageUrl: String,

    @ColumnInfo(name = "algorithm")
    val algorithm: String,

    @ColumnInfo(name = "url")
    val url: String,

    @ColumnInfo(name = "blockTime")
    val blockTime: Int,

    @ColumnInfo(name = "maxSupply")
    val maxSupply: Int,

    @ColumnInfo(name = "netHashesPerSecond")
    val netHashesPerSecond: Int,

    @ColumnInfo(name = "blockNumber")
    val blockNumber: Int,

    @ColumnInfo(name = "blockReward")
    val blockReward: Int,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
) : Parcelable