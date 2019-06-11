package by.arro.vocab.presentation.main

import by.arro.vocab.domain.entity.Word
import by.arro.vocab.domain.interactors.GetWordsInteractor
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainPresenterImpl(
    private val getWordsInteractor: GetWordsInteractor
) : MainPresenter {

    private var view: MainView? = null
    private var items: List<Word> = listOf()

    private val compositeDisposable = CompositeDisposable()

    override fun firstAttach(view: MainView) {
        this.view = view
        initLoad()
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

    override fun detach() {
        view = null
    }

    override fun destroy() {
        view = null
        compositeDisposable.dispose()
    }

    private fun MainView.renderAll() {
        updateWords(items)
    }

    private fun initLoad() {
        val disposable = Single.fromCallable { getWordsInteractor.get() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { items ->
                this.items = items
                view?.updateWords(items)
            }

        compositeDisposable.add(disposable)
    }
}