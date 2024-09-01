package com.kuldeep.dictionaryapp.feature.feature_wordDetails.presentation.viewmodel

import com.kuldeep.dictionaryapp.feature.feature_wordDetails.domain.usecase.GetWordDetailsUseCase
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.presentation.event.WordUiEvent
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.presentation.state.WordUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class WordDetailsViewModel @Inject constructor(
    private val getWordDetailsUseCase: GetWordDetailsUseCase,
) {
    private val _uiState :MutableStateFlow<WordUiState> = MutableStateFlow(WordUiState())
    val uiState: StateFlow<WordUiState> = _uiState.asStateFlow()



    fun onEvent(event: WordUiEvent) {
        when (event) {
            is WordUiEvent.LoadInitialWord -> loadWord()
            is WordUiEvent.SearchWord -> searchWord(event.word)
            is WordUiEvent.Retry -> retryLoading()
            is WordUiEvent.ShowErrorMessage -> showError(event.message)
        }
    }


    private fun loadWord() {
        // Load the word data and update _uiState
    }

    private fun searchWord(query: String) {
        // Perform search and update _uiState
    }

    private fun retryLoading() {

    }

    private fun showError(message: String) {
        _uiState.value = _uiState.value.copy(error = message)
    }
}