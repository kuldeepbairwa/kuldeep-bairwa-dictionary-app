package com.kuldeep.dictionaryapp.feature.feature_searchHistory.presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kuldeep.dictionaryapp.feature.feature_search.presentation.viewmodel.SearchWordViewModel
import com.kuldeep.dictionaryapp.feature.feature_searchHistory.presentation.viewmodel.SearchHistoryViewModel
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.domain.model.Word

@Composable
fun SearchHistoryScreen(viewModel: SearchHistoryViewModel, onWordSearch: (String) -> Unit) {

    val wordsHistory by viewModel.uiState.collectAsState()

    // Display the list of words
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(items = wordsHistory){
            WordItem(word = it,onWordSearch)
        }
    }

}

@Composable
fun WordItem(word: Word,onWordSearch: (String) -> Unit) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 8.dp)
        .clickable {
            onWordSearch(word.word)
        }
    ) {
        Text(
            text = word.word,
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary
        )
    }
}