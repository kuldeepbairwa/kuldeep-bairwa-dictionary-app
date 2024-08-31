package com.kuldeep.dictionaryapp.feature.feature_wordDetails.domain.model

data class Word(
    val word: String,
    val meanings: List<Meaning>
)