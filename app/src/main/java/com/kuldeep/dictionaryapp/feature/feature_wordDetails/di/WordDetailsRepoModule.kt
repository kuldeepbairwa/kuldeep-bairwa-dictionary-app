package com.kuldeep.dictionaryapp.feature.feature_wordDetails.di

import com.kuldeep.dictionaryapp.feature.feature_wordDetails.data.repository.WordDetailsRepositoryImpl
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.domain.repository.WordsDetailsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
abstract class WordDetailsRepoModule {

    @Singleton
    @Binds
    abstract fun providesWordDetailsRepository(repository: WordDetailsRepositoryImpl): WordsDetailsRepository
}