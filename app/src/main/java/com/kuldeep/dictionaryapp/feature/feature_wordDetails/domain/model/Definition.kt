package com.kuldeep.dictionaryapp.feature.feature_wordDetails.domain.model

data class Definition(
    val definition: String,
    val example: String?,
    val synonyms: List<String>,
    val antonyms: List<String>
)
