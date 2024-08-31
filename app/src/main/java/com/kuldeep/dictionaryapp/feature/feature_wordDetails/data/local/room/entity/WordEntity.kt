package com.kuldeep.dictionaryapp.feature.feature_wordDetails.data.local.room.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.data.model.MeaningDTO
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.data.model.toMeaning
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.domain.model.Meaning
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.domain.model.Word
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "word_details")
data class WordEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val word: String,
    val meanings: Meanings
)

@Serializable
data class Meanings(
    val meanings: List<MeaningDTO>
)

fun WordEntity.toWord(): Word {
    return Word(
        word = word,
        meanings = meanings.meanings.map { it.toMeaning() }
    )
}