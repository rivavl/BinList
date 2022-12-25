package com.marina.binlist.domain.use_case

import com.marina.binlist.domain.entity.CardInfo
import com.marina.binlist.domain.repository.BINRepository
import com.marina.binlist.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCardInfoByBIN @Inject constructor(
    private val repository: BINRepository
) {
    suspend operator fun invoke(bin: String): Flow<Resource<CardInfo>> {
        return repository.getCardInfo(bin)
    }
}