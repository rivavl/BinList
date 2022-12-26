package com.marina.binlist.presentation.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Country(
    val letter: String?,
    val currency: String?,
    val latitude: Int?,
    val longitude: Int?,
    val name: String?,
    val numeric: String?
):Parcelable