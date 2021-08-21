package com.aemiralfath.agit.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

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
    val blockTime: Double,

    @ColumnInfo(name = "maxSupply")
    val maxSupply: Double,

    @ColumnInfo(name = "blockNumber")
    val blockNumber: Double,

    @ColumnInfo(name = "blockReward")
    val blockReward: Double,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)