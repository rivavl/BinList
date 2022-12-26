package com.marina.binlist.presentation.entity

data class ListState(
    val data: List<CardInfoUI>?,
    val isLoading: Boolean?,
    val hasError: Boolean?
)