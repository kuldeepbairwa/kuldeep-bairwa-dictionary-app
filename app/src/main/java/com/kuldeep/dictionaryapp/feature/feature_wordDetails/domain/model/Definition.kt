package com.kuldeep.dictionaryapp.feature.feature_wordDetails.domain.model

import com.kuldeep.dictionaryapp.feature.feature_wordDetails.data.model.DefinitionDTO

data class Definition(
    val definition: String,
    val example: String?,
)
fun Definition.toDefinitionDTO(): DefinitionDTO {
    return DefinitionDTO(
        definition = definition,
        example = example
    )
}