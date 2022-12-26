package com.marina.binlist.presentation.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Bank(
    val name: String?,
    val url: String?,
    val phone: String?,
    val city: String?,
) : Parcelable