package com.kuldeep.dictionaryapp.feature.feature_wordDetails.domain.model

import com.kuldeep.dictionaryapp.feature.feature_wordDetails.data.model.MeaningDTO
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.data.model.toDefinition

data class Meaning(
    val partOfSpeech: String,
    val synonyms: List<String>,
    val antonyms: List<String>,
    val definitions: List<Definition>
)


fun Meaning.toMeaningDTO(): MeaningDTO {
    return MeaningDTO(
        partOfSpeech = partOfSpeech,
        antonyms = antonyms,
        synonyms = synonyms,
        definitions = definitions.map { it.toDefinitionDTO() }
    )

}