package com.kuldeep.dictionaryapp.feature.feature_wordDetails.data.model

import com.kuldeep.dictionaryapp.feature.feature_wordDetails.domain.model.Meaning
import kotlinx.serialization.Serializable

@Serializable
data class MeaningDTO(
    val partOfSpeech: String,
    val definitions: List<DefinitionDTO>,
    val synonyms: List<String>,
    val antonyms: List<String>
)


fun MeaningDTO.toMeaning(): Meaning {
    return Meaning(
        partOfSpeech = partOfSpeech,
        definitions = definitions.map { it.toDefinition() }
    )
}