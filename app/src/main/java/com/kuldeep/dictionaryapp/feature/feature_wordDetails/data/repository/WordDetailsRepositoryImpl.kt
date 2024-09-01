package com.kuldeep.dictionaryapp.feature.feature_wordDetails.data.repository

import com.kuldeep.dictionaryapp.core.network.DictionaryErrorResponse
import com.kuldeep.dictionaryapp.core.network.ErrorResponseMapper
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.data.local.room.dao.WordDAO
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.data.local.room.entity.toDTO
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.data.local.room.entity.toWord
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.data.model.WordDTO
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.data.model.toWord
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.data.model.toWordEntity
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.data.remote.DictionaryApiService
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.domain.model.Word
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.domain.repository.WordsDetailsRepository
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.getOrNull
import com.skydoves.sandwich.map
import com.skydoves.sandwich.message
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onSuccess
import com.skydoves.sandwich.retrofit.serialization.onErrorDeserialize
import com.skydoves.sandwich.suspendOnError
import com.skydoves.sandwich.suspendOnException
import com.skydoves.sandwich.suspendOnFailure
import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WordDetailsRepositoryImpl @Inject constructor(
    private val apiService: DictionaryApiService,
    private val wordDAO: WordDAO
) : WordsDetailsRepository {
    override suspend fun getWordDetails(word: String): ApiResponse<Word?> {
        val cachedWord = wordDAO.getWord(word)

        if (cachedWord != null) return (ApiResponse.Success(data = cachedWord.toWord()))

        val apiResponse = apiService.fetchWordDetails()

        return when(apiResponse){
            is ApiResponse.Failure.Error -> {
                apiResponse
            }
            is  ApiResponse.Failure.Exception-> {
                apiResponse
            }
            is ApiResponse.Success -> {
                ApiResponse.Success(apiResponse.data.firstOrNull()?.toWord())
            }
        }
    }

    override suspend fun saveWord(word: WordDTO) {
        wordDAO.insertWord(word.toWordEntity())
    }
}