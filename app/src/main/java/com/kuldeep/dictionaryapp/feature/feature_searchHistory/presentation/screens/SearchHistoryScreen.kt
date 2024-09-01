package com.kuldeep.dictionaryapp.feature.feature_searchHistory.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
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
            .padding(horizontal = 16.dp)
    ) {
        items(items = wordsHistory){
            WordItem(word = it,onWordSearch)
        }
    }

}

@Composable
fun WordItem(word: Word, onWordSearch: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 8.dp)
            .background(
                color = MaterialTheme.colorScheme.primaryContainer,
                shape = RoundedCornerShape(8.dp)
            )
            .clickable {
                onWordSearch(word.word)
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement =  Arrangement.Start// Add horizontal alignment
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(), // Apply a background to see the bounds
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = word.word,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                textAlign = TextAlign.Left,
                modifier = Modifier
                    .padding(vertical = 12.dp, horizontal = 2.dp)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))
    }
}
