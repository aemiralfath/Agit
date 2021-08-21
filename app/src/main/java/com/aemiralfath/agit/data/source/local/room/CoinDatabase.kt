package com.aemiralfath.agit.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aemiralfath.agit.data.source.local.entity.CoinEntity

@Database(entities = [CoinEntity::class], version = 1, exportSchema = false)
abstract class CoinDatabase : RoomDatabase() {
    abstract fun coinDao(): CoinDao
}