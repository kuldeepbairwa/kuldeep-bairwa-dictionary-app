package com.kuldeep.dictionaryapp.feature.feature_wordDetails.data.remote

import com.kuldeep.dictionaryapp.feature.feature_wordDetails.data.model.WordDTO
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface DictionaryApiService {

    @GET("entries/en/{word}")
    suspend fun fetchWordDetails(
        @Path("word") word: String
    ): ApiResponse<ArrayList<WordDTO>>
}