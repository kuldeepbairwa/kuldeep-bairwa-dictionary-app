package com.kuldeep.dictionaryapp.feature.feature_wordDetails.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.domain.model.Word
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.presentation.event.WordUiEvent
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.presentation.state.WordUiState
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.presentation.viewmodel.WordDetailsViewModel

@Composable
fun WordDetailsScreen(
    viewModel: WordDetailsViewModel,
    navController: NavController,
    queryWord: String?
) {
    // Collect the UI state from the ViewModel
    val state by viewModel.uiState.collectAsState()

    LaunchedEffect(queryWord) {
        if (!state.isLoading && state.word == null && queryWord != null) {
            viewModel.onEvent(WordUiEvent.SearchWord(queryWord))
        }
    }
    // Handle different UI states
    when {
        state.isLoading -> {
            // Show a loading indicator
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(modifier = Modifier.size(60.dp))
            }
        }

        state.error != null -> {
            // Show an error message
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Error: ${state.error}", color = MaterialTheme.colorScheme.error)
                Button(onClick = { /* Handle retry or go back */ }) {
                    Text(text = "Retry")
                }
            }
        }

        else -> {
            // Show word details
            state.word?.let { word ->
                WordDetailsContent(word)
            } ?: run {
                Text(
                    text = "Word not found.",
                    modifier = Modifier.fillMaxSize(),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun WordDetailsContent(word: Word) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = word.word,
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        word.meanings.forEach { meaning ->
            Text(
                text = meaning.partOfSpeech,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(vertical = 4.dp)
            )
            meaning.definitions.forEach { definition ->
                Text(
                    text = definition.definition,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(vertical = 2.dp)
                )
                definition.example?.let {
                    Text(
                        text = "Example: $it",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(vertical = 2.dp, horizontal = 8.dp)
                    )
                }
            }
        }
    }
}
