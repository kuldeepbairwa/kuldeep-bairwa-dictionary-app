package com.kuldeep.dictionaryapp.feature.feature_wordDetails.domain.usecase

import com.kuldeep.dictionaryapp.feature.feature_wordDetails.domain.model.Word
import com.kuldeep.dictionaryapp.feature.feature_wordDetails.domain.repository.DictionaryRepository
import javax.inject.Inject

class GetWordDetailsUseCase @Inject constructor (private val repository: DictionaryRepository) {
    suspend operator fun invoke(word: String): List<Word> {
        return repository.getWordDetails(word)
    }
}