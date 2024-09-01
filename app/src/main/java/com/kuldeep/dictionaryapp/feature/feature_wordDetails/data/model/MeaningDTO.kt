package com.kuldeep.dictionaryapp.feature.feature_wordDetails.data.model

import com.kuldeep.dictionaryapp.feature.feature_wordDetails.domain.model.Meaning
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MeaningDTO(
    val partOfSpeech: String,
    @SerialName("definitions") val definitions: List<DefinitionDTO>,
    @SerialName("synonyms") val synonyms: List<String> = emptyList(),
    @SerialName("antonyms") val antonyms: List<String> = emptyList()
)

fun MeaningDTO.toMeaning(): Meaning {
    return Meaning(
        partOfSpeech = partOfSpeech,
        synonyms = synonyms,
        antonyms = antonyms,
        definitions = definitions.map { it.toDefinition() }
    )

}