package com.kuldeep.dictionaryapp.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.data.local.room.dao.WordDAO
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.data.local.room.entity.WordEntity

@Database(entities = [WordEntity::class], version = 1, exportSchema = false)
@TypeConverters(value = [MeaningsTypeConverter::class])
abstract class DictionaryDatabase:RoomDatabase() {

    abstract fun wordDao(): WordDAO

    companion object{
        const val DATABASE_NAME = "DictionaryAppDatabase"
    }
}