package com.kuldeep.dictionaryapp.core.database

import androidx.room.TypeConverter
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.data.local.room.entity.Meanings
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.domain.model.Meaning
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class MeaningsTypeConverter {


    @TypeConverter
    fun fromMeanings(meanings: Meanings): String {
        return Json.encodeToString(meanings)
    }

    @TypeConverter
    fun toMeanings(meaningsString: String): Meanings {
        return Json.decodeFromString(meaningsString)
    }
}