package com.kuldeep.dictionaryapp.feature.feature_wordDetails.presentation.state

import com.kuldeep.dictionaryapp.feature.feature_wordDetails.domain.model.Meaning

data class WordUiState(
    val word: String = "",
    val meanings: List<Meaning> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)