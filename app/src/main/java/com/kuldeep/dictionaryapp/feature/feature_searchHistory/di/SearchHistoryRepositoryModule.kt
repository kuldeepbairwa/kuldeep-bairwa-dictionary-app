package com.kuldeep.dictionaryapp.feature.feature_searchHistory.di

import com.kuldeep.dictionaryapp.feature.feature_searchHistory.data.SearchHistoryRepositoryImpl
import com.kuldeep.dictionaryapp.feature.feature_searchHistory.domain.repository.SearchHistoryRepository
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.domain.repository.WordsDetailsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class SearchHistoryRepositoryModule {

    @Singleton
    @Binds
    abstract fun providesSearchHistoryRepository(repository: SearchHistoryRepositoryImpl): SearchHistoryRepository
}