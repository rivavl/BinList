package com.marina.binlist.presentation.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MainInfo(
    val prepaid: Boolean?,
    val scheme: String?,
    val type: String?,
    val brand: String?,
) : Parcelable