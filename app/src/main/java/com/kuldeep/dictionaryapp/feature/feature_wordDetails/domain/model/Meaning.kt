package com.kuldeep.dictionaryapp.feature.feature_wordDetails.domain.model

data class Meaning(
    val partOfSpeech: String,
    val definitions: List<Definition>
)