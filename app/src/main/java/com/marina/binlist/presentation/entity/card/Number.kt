package com.marina.binlist.presentation.entity.card

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Number(
    val length: Int?,
    val luhn: Boolean?
) : Parcelable