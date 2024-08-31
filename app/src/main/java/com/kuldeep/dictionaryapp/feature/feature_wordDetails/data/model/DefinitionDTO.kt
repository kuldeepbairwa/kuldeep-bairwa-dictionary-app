package com.kuldeep.dictionaryapp.feature.feature_wordDetails.data.model

import com.kuldeep.dictionaryapp.feature.feature_wordDetails.domain.model.Definition
import kotlinx.serialization.Serializable

@Serializable
data class DefinitionDTO(
    val definition: String,
    val example: String?,
    val synonyms: List<String>,
    val antonyms: List<String>
)

fun DefinitionDTO.toDefinition(): Definition {

    return Definition(
        definition = definition,
        example = example,
        synonyms = synonyms,
        antonyms = antonyms
    )
}
