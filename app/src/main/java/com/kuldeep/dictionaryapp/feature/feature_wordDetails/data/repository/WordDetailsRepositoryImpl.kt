package com.kuldeep.dictionaryapp.feature.feature_wordDetails.data.repository

import com.kuldeep.dictionaryapp.feature.feature_wordDetails.data.local.room.dao.WordDAO
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.data.model.WordDTO
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.data.model.toWordEntity
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.data.remote.DictionaryApiService
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.domain.model.Word
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.domain.repository.WordsDetailsRepository
import javax.inject.Inject

class WordDetailsRepositoryImpl @Inject constructor(
    private val apiService: DictionaryApiService,
    private val wordDAO: WordDAO
) : WordsDetailsRepository {
    override suspend fun getWordDetails(word: String): List<Word> {
        return listOf()
    }

    override suspend fun saveWord(word: WordDTO) {
        wordDAO.insertWord(word.toWordEntity())
    }
}