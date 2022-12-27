package com.marina.binlist.presentation.entity

import com.marina.binlist.presentation.entity.card.CardInfoUI

data class ListState(
    val data: List<CardInfoUI>?,
    val isLoading: Boolean?,
    val hasError: Boolean?
)