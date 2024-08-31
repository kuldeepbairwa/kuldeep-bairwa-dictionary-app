package com.kuldeep.dictionaryapp.feature.feature_wordDetails.domain.repository

import com.kuldeep.dictionaryapp.feature.feature_wordDetails.data.model.WordDTO
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.domain.model.Word

interface WordsDetailsRepository {
    suspend fun getWordDetails(word: String): List<Word>
    suspend fun saveWord(word: WordDTO)
}