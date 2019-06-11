package by.arro.vocab.presentation.main

class MainPresenterImpl : MainPresenter {
    private var view: MainView? = null

    override fun firstAttach(view: MainView) {
        this.view = view
    }

    override fun attach(view: MainView) {
        this.view = view
    }

    override fun onAddClicked() {

    }

    override fun onWordCliked(itemId: Int) {

    }

    override fun destroy() {
        view = null
    }
}