package by.arro.vocab.presentation.main

import by.arro.vocab.domain.entity.Word

class MainPresenterImpl : MainPresenter {
    private var view: MainView? = null
    private var items: List<Word> = listOf(
            Word(1, "1", "1"),
            Word(2, "2", "1"),
            Word(3, "3", "1"),
            Word(4, "4", "1")
    )

    override fun firstAttach(view: MainView) {
        this.view = view
        view.renderAll()
    }

    override fun attach(view: MainView) {
        this.view = view
        view.renderAll()
    }

    override fun onAddClicked() {

    }

    override fun onWordCliked(itemId: Int) {

    }

    override fun destroy() {
        view = null
    }

    private fun MainView.renderAll() {
        updateWords(items)
    }
}