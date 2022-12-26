package com.marina.binlist.domain.repository

import com.marina.binlist.domain.entity.CardInfo
import com.marina.binlist.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface BINRepository {
    suspend fun getCardInfo(bin: String): Flow<Resource<CardInfo>>

    suspend fun getCardsFromHistory(): Flow<Resource<List<CardInfo>>>
}