package com.kuldeep.dictionaryapp.feature.feature_wordDetails.domain.model

import com.kuldeep.dictionaryapp.feature.feature_wordDetails.data.model.DefinitionDTO

data class Definition(
    val definition: String,
    val example: String?,
    val synonyms: List<String>,
    val antonyms: List<String>
)
fun Definition.toDefinitionDTO(): DefinitionDTO {
    return DefinitionDTO(
        definition = definition,
        example = example,
        synonyms = synonyms,
        antonyms = antonyms
    )
}