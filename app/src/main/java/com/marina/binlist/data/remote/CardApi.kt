package com.marina.binlist.data.remote

import com.marina.binlist.data.remote.dto.CardInfoDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CardApi {
    @GET("{cardNumber}")
    suspend fun getCharacters(
        @Path("cardNumber") cardNumber: String
    ): Response<CardInfoDto>
}