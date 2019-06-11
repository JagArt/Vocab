package by.arro.vocab.domain.interactors

import by.arro.vocab.domain.entity.Word

interface GetWordsInteractor {
    fun get(): List<Word>
}