package by.arro.vocab.presentation.main

interface MainPresenter {
    fun firstAttach(view: MainView)
    fun attach(view: MainView)
    fun destroy()
    fun detach()

    fun onAddClicked()
    fun onWordCliked(itemId: Int)
}