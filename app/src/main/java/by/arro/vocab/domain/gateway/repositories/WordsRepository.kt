package by.arro.vocab.domain.gateway.repositories

import by.arro.vocab.domain.entity.Word

interface WordsRepository {
    fun getAll(): List<Word>
}