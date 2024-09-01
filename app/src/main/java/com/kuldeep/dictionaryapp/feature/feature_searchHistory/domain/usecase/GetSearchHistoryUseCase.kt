package com.kuldeep.dictionaryapp.feature.feature_searchHistory.domain.usecase

import com.kuldeep.dictionaryapp.feature.feature_searchHistory.domain.repository.SearchHistoryRepository
import javax.inject.Inject

class GetSearchHistoryUseCase @Inject constructor(
    private val repository: SearchHistoryRepository
) {
    operator fun invoke() = repository.getSavedWords()
}