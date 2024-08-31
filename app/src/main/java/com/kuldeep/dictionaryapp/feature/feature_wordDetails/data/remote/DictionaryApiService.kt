package com.kuldeep.dictionaryapp.feature.feature_wordDetails.data.remote

import com.kuldeep.dictionaryapp.feature.feature_wordDetails.data.model.WordDTO
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET

interface DictionaryApiService {

    @GET
    suspend fun fetchWordDetails(): ApiResponse<List<WordDTO>>
}