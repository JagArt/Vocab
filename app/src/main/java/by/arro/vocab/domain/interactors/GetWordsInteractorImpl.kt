package by.arro.vocab.domain.interactors

import by.arro.vocab.domain.entity.Word
import by.arro.vocab.domain.gateway.repositories.WordsRepository

class GetWordsInteractorImpl(
        private val wordsRepository: WordsRepository
): GetWordsInteractor {

    override fun get(): List<Word> {
        return wordsRepository.getAll()
    }
}