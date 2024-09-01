package com.kuldeep.dictionaryapp.core.database

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.data.local.room.dao.WordDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    @Synchronized
    fun providesDictionaryDB(@ApplicationContext context: Context):DictionaryDatabase{
        return Room.databaseBuilder(
            context,
            DictionaryDatabase::class.java,
            DictionaryDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun providesWordDAO(dictionaryDatabase: DictionaryDatabase): WordDAO {
        return dictionaryDatabase.wordDao()
    }


}