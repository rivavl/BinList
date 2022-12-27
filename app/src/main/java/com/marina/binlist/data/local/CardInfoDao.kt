package com.marina.binlist.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.marina.binlist.data.local.entity.CardDB

@Dao
interface CardInfoDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun saveCard(card: CardDB)

    @Query("select * from cards")
    suspend fun getCards(): List<CardDB>

    @Query("select * from cards where bin=:bin")
    suspend fun getCard(bin: String): CardDB
}