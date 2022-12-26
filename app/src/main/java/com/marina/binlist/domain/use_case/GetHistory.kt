package com.marina.binlist.domain.use_case

import com.marina.binlist.domain.entity.CardInfo
import com.marina.binlist.domain.repository.BINRepository
import com.marina.binlist.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetHistory @Inject constructor(
    private val repository: BINRepository
) {
    suspend operator fun invoke(): Flow<Resource<List<CardInfo>>> {
        return repository.getCardsFromHistory()
    }
}