package com.marina.binlist.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "cards", indices = [Index(value = ["bin"], unique = true)])
data class CardDB(
    @ColumnInfo(name = "bin")
    @PrimaryKey
    val bin: String,
    @ColumnInfo(name = "numberLength")
    val numberLength: Int,
    @ColumnInfo(name = "hasLuhnAlg")
    val hasLuhnAlg: Boolean,
    @ColumnInfo(name = "scheme")
    val scheme: String,
    @ColumnInfo(name = "type")
    val type: String?,
    @ColumnInfo(name = "brand")
    val brand: String?,
    @ColumnInfo(name = "prepaid")
    val prepaid: Boolean?,
    @ColumnInfo(name = "countryNumeric")
    val countryNumeric: String?,
    @ColumnInfo(name = "countryAlpha2")
    val countryAlpha2: String?,
    @ColumnInfo(name = "countryName")
    val countryName: String?,
    @ColumnInfo(name = "countryCurrency")
    val countryCurrency: String?,
    @ColumnInfo(name = "countryLatitude")
    val countryLatitude: Int?,
    @ColumnInfo(name = "countryLongitude")
    val countryLongitude: Int?,
    @ColumnInfo(name = "bankName")
    val bankName: String?,
    @ColumnInfo(name = "bankUrl")
    val bankUrl: String?,
    @ColumnInfo(name = "bankPhone")
    val bankPhone: String?,
    @ColumnInfo(name = "bankCity")
    val bankCity: String?
)