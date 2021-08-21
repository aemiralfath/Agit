package com.aemiralfath.agit.data.source.local.room

import androidx.room.*
import com.aemiralfath.agit.data.source.local.entity.CoinEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CoinDao {

    @Query("SELECT * FROM coin")
    fun getAllCoin(): Flow<List<CoinEntity>>

    @Query("SELECT * FROM coin where isFavorite = 1")
    fun getFavoriteCoin(): Flow<List<CoinEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCoin(movie: List<CoinEntity>)

    @Update
    fun updateFavoriteCoin(coin: CoinEntity)
}