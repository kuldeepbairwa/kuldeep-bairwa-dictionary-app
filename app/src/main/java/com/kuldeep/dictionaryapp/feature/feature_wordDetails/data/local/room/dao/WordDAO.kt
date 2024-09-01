package com.kuldeep.dictionaryapp.feature.feature_wordDetails.data.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.data.local.room.entity.WordEntity
import kotlinx.coroutines.flow.Flow

@Dao
abstract class WordDAO {

    @Query("SELECT * FROM word_details WHERE word = :word")
    abstract fun getWord(word: String): WordEntity?

    @Query("SELECT * FROM word_details")
    abstract fun getAllWords(): Flow<List<WordEntity>>

    @Query("DELETE FROM word_details WHERE word = :word")
    abstract fun deleteWord(word: String)

    @Query("DELETE FROM word_details")
    abstract fun deleteAllWords()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertWord(word: WordEntity)

}