package by.arro.vocab.data.repository

import by.arro.vocab.domain.entity.Word
import by.arro.vocab.domain.gateway.repositories.WordsRepository

class SqlWordsRepository: WordsRepository {
    override fun getAll(): List<Word> {
        return listOf(
                Word(1, "1", "1"),
                Word(2, "2", "1"),
                Word(3, "3", "1"),
                Word(4, "4", "1"))
    }
}