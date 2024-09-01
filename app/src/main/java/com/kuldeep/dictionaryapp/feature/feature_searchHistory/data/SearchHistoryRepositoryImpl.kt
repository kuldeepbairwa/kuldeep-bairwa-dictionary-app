package com.kuldeep.dictionaryapp.feature.feature_searchHistory.data

import com.kuldeep.dictionaryapp.feature.feature_searchHistory.domain.repository.SearchHistoryRepository
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.data.local.room.dao.WordDAO
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.data.local.room.entity.toWord
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.domain.model.Word
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SearchHistoryRepositoryImpl @Inject constructor(
    private val wordDAO: WordDAO
): SearchHistoryRepository {

    override fun getSavedWords(): Flow<List<Word>> {
        return wordDAO.getAllWords().map { words -> words.map { it.toWord() } } }

}