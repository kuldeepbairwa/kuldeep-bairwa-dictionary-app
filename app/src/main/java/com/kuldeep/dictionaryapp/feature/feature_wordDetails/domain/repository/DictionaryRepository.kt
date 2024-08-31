package com.kuldeep.dictionaryapp.feature.feature_wordDetails.domain.repository

import com.kuldeep.dictionaryapp.feature.feature_wordDetails.domain.model.Word

interface DictionaryRepository {
    suspend fun getWordDetails(word: String): List<Word>
}