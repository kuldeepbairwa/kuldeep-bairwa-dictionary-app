package com.kuldeep.dictionaryapp.feature.feature_wordDetails.presentation.state

import com.kuldeep.dictionaryapp.feature.feature_wordDetails.domain.model.Meaning
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.domain.model.Word

data class WordUiState(
    val word: Word? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)