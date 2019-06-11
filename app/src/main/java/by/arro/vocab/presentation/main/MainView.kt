package by.arro.vocab.presentation.main

import by.arro.vocab.domain.entity.Word

interface MainView {
    fun updateWords(items: List<Word>)
}