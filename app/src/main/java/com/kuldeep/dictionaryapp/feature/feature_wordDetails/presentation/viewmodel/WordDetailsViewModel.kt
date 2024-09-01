package com.kuldeep.dictionaryapp.feature.feature_wordDetails.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.domain.usecase.GetWordDetailsUseCase
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.presentation.event.WordUiEvent
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.presentation.state.WordUiState
import com.skydoves.sandwich.message
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WordDetailsViewModel @Inject constructor(
    private val getWordDetailsUseCase: GetWordDetailsUseCase
) : ViewModel() {

    private val _uiState: MutableStateFlow<WordUiState> = MutableStateFlow(WordUiState(isLoading = true))
    val uiState: StateFlow<WordUiState> = _uiState.asStateFlow()

    init {
        // Initialize with an idle state if necessary
        _uiState.value = WordUiState(isLoading = false)
    }

    fun onEvent(event: WordUiEvent) {
        when (event) {
            is WordUiEvent.Idle -> Unit
            is WordUiEvent.SearchWord -> searchWord(event.word)
            is WordUiEvent.ShowErrorMessage -> showError(event.message)
        }
    }


    private fun searchWord(word: String) {
        _uiState.value = _uiState.value.copy(isLoading = true, error = null)
        viewModelScope.launch(Dispatchers.IO) {
            getWordDetailsUseCase(word).onSuccess {
                data?.apply {
                    _uiState.value = _uiState.value.copy(word = this, isLoading = false)
                }
            }.onError {
                showError(this.message())
            }
        }
    }

    private fun showError(message: String) {
        _uiState.value = _uiState.value.copy(
            error = message,
            isLoading = false
        )
    }
}
