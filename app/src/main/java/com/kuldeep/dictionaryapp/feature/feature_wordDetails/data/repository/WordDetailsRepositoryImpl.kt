package com.kuldeep.dictionaryapp.feature.feature_wordDetails.data.repository

import com.kuldeep.dictionaryapp.core.network.ErrorEnvelopeMapper
import com.kuldeep.dictionaryapp.core.network.ErrorEnvelopeMapper.map
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.data.local.room.dao.WordDAO
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.data.local.room.entity.toWord
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.data.model.WordDTO
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.data.model.toWord
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.data.model.toWordEntity
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.data.remote.DictionaryApiService
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.domain.model.Word
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.domain.repository.WordsDetailsRepository
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.map
import com.skydoves.sandwich.message
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.retrofit.apiMessage
import com.skydoves.sandwich.retrofit.statusCode
import javax.inject.Inject

class WordDetailsRepositoryImpl @Inject constructor(
    private val apiService: DictionaryApiService,
    private val wordDAO: WordDAO
) : WordsDetailsRepository {
    override suspend fun getWordDetails(wordQuery: String): ApiResponse<Word?> {
        val cachedWord = wordDAO.getWord(wordQuery)

        if (cachedWord != null) return (ApiResponse.Success(data = cachedWord.toWord()))
        else {
            val apiResponse = apiService.fetchWordDetails(wordQuery)

            return when (apiResponse) {
                is ApiResponse.Failure.Error -> {
                    apiResponse
                }

                is ApiResponse.Failure.Exception -> {
                    apiResponse
                }

                is ApiResponse.Success -> {
                    val word = apiResponse.data.firstOrNull()
                    if (word != null) {
                        saveWord(word)
                    }
                    ApiResponse.Success(word?.toWord())
                }
            }
        }
    }

    override suspend fun saveWord(word: WordDTO) {
        wordDAO.insertWord(word.toWordEntity())
    }
}