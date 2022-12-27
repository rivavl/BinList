package com.marina.binlist.presentation.entity.card

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CardInfoUI(
    val bin: String,
    val bank: Bank?,
    val country: Country?,
    val number: Number?,
    val mainInfo: MainInfo?
) : Parcelable