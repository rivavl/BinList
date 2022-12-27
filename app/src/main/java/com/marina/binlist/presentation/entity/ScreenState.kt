package com.marina.binlist.presentation.entity

import com.marina.binlist.presentation.entity.card.CardInfoUI

data class ScreenState(
    val info: CardInfoUI? = null,
    val isLoading: Boolean? = null,
    val hasError: Boolean? = null
)