package com.kuldeep.dictionaryapp.feature.feature_wordDetails.data.repository

import com.kuldeep.dictionaryapp.feature.feature_wordDetails.domain.model.Word
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.domain.repository.WordsDetailsRepository
import javax.inject.Inject

class WordDetailsRepositoryImpl @Inject constructor() :WordsDetailsRepository{
    override suspend fun getWordDetails(word: String): List<Word> {
        return listOf()
    }
}