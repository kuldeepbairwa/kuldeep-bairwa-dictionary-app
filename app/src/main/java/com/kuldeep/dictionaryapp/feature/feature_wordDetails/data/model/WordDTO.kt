package com.kuldeep.dictionaryapp.feature.feature_wordDetails.data.model

import com.kuldeep.dictionaryapp.feature.feature_wordDetails.data.local.room.entity.Meanings
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.data.local.room.entity.WordEntity
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.domain.model.Word
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WordDTO(
    @SerialName("word"     ) var word     : String           = "",
    @SerialName("meanings" ) var meanings : ArrayList<MeaningDTO> = arrayListOf()
)


fun WordDTO.toWordEntity(): WordEntity {
    return WordEntity(
        word = word,
        meanings = Meanings(meanings)
    )
}

fun WordDTO.toWord(): Word {
    return Word(
        word = word,
        meanings = meanings.map { it.toMeaning() }
    )
}