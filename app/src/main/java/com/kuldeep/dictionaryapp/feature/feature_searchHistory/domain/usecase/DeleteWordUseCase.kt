package com.kuldeep.dictionaryapp.feature.feature_searchHistory.domain.usecase

import com.kuldeep.dictionaryapp.feature.feature_searchHistory.domain.repository.SearchHistoryRepository
import javax.inject.Inject

class DeleteWordUseCase @Inject constructor(private val wordRepository: SearchHistoryRepository) {

    suspend operator fun invoke(word: String) {
        wordRepository.deleteWord(word)
    }

}