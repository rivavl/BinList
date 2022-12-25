package com.marina.binlist.domain.entity

data class CardInfo(
    val numberLength: Int,
    val hasLuhnAlg: Boolean,
    val scheme: String,
    val type: String?,
    val brand: String?,
    val prepaid: Boolean?,
    val countryNumeric: String?,
    val countryAlpha2: String?,
    val countryName: String?,
    val countryCurrency: String?,
    val countryLatitude: Int?,
    val countryLongitude: Int?,
    val bankName: String?,
    val bankUrl: String?,
    val bankPhone: String?,
    val bankCity: String?,
)