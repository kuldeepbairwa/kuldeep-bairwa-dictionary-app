package com.kuldeep.dictionaryapp.feature.feature_wordDetails.data.model

import com.kuldeep.dictionaryapp.feature.feature_wordDetails.domain.model.Definition
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DefinitionDTO(
    @SerialName("definition") val definition: String = "",
    @SerialName("example") val example: String? = null, // Example is now nullable
)

fun DefinitionDTO.toDefinition(): Definition {

    return Definition(
        definition = definition,
        example = example
    )
}
