package com.kuldeep.dictionaryapp.feature.feature_searchHistory.domain.repository

import com.kuldeep.dictionaryapp.feature.feature_wordDetails.domain.model.Word
import kotlinx.coroutines.flow.Flow

interface SearchHistoryRepository {

    fun getSavedWords(): Flow<List<Word>>

    suspend fun deleteWord(word: String)

}