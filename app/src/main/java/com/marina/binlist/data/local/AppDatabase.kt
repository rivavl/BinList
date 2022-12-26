package com.marina.binlist.data.local

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.marina.binlist.data.local.entity.CardDB

@Database(entities = [CardDB::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract val cardInfoDao: CardInfoDao

    companion object {
        private var INSTANCE: AppDatabase? = null
        private val LOCK = Any()
        private const val DB_NAME = "cards.db"

        fun getInstance(application: Application): AppDatabase {
            INSTANCE?.let {
                return it
            }
            synchronized(LOCK) {
                INSTANCE?.let {
                    return it
                }
                val db = Room.databaseBuilder(
                    application,
                    AppDatabase::class.java,
                    DB_NAME
                )
                    .build()
                INSTANCE = db
                return db
            }
        }
    }
}