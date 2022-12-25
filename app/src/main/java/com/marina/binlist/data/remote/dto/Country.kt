package com.marina.binlist.data.remote.dto

import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("alpha2")
    val letter: String,
    @SerializedName("currency")
    val currency: String,
    @SerializedName("latitude")
    val latitude: Int,
    @SerializedName("longitude")
    val longitude: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("numeric")
    val numeric: String
)