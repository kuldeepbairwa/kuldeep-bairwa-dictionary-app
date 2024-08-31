package com.kuldeep.dictionaryapp.feature.feature_wordDetails.domain.model

import com.kuldeep.dictionaryapp.feature.feature_wordDetails.data.local.room.entity.Meanings
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.data.local.room.entity.WordEntity

data class Word(
    val word: String,
    val meanings: List<Meaning>
)

fun Word.toWordEntity(): WordEntity {
    return WordEntity(
        word = word,
        meanings = Meanings(meanings.map { it.toMeaningDTO() })
    )
}