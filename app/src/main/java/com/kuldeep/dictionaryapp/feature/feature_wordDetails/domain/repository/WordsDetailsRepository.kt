package com.kuldeep.dictionaryapp.feature.feature_wordDetails.domain.repository

import com.kuldeep.dictionaryapp.feature.feature_wordDetails.data.model.WordDTO
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.domain.model.Word
import com.skydoves.sandwich.ApiResponse
import kotlinx.coroutines.flow.Flow

interface WordsDetailsRepository {
    suspend fun getWordDetails(wordQuery: String): ApiResponse<Word?>
    suspend fun saveWord(word: WordDTO)
}