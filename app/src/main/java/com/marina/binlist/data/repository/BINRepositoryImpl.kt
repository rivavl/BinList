package com.marina.binlist.data.repository

import com.marina.binlist.data.mapper.toDomain
import com.marina.binlist.data.remote.CardApi
import com.marina.binlist.domain.entity.CardInfo
import com.marina.binlist.domain.repository.BINRepository
import com.marina.binlist.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class BINRepositoryImpl @Inject constructor(
    private val api: CardApi
) : BINRepository {

    override suspend fun getCardInfo(bin: String): Flow<Resource<CardInfo>> = flow {
        emit(Resource.Loading())
        val response = api.getCharacters(bin)
        if (response.isSuccessful) {
            emit(Resource.Success(response.body()!!.toDomain()))
        } else {
            emit(Resource.Error(response.message()))
        }
    }
}