package by.arro.vocab.presentation.main

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import by.arro.vocab.R
import by.arro.vocab.domain.entity.Word
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupPresenter()
        initViews()
    }

    override fun onDestroy() {
        presenter.destroy()
        super.onDestroy()
    }

    override fun updateWords(items: List<Word>) {
        adapter.update(items)
    }

    private fun setupPresenter() {
        presenter = (lastCustomNonConfigurationInstance as MainPresenter?)?.apply {
            attach(this@MainActivity)
        } ?: MainPresenterImpl().apply {
            firstAttach(this@MainActivity)
        }
    }

    private fun initViews() {
        fabAdd.setOnClickListener { presenter.onAddClicked() }
        initRecycleView()
    }

    private fun initRecycleView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = WordsAdapter(this, onItemClicked = { itemId ->
            presenter.onWordCliked(itemId)
        })
    }

    override fun onRetainCustomNonConfigurationInstance(): Any {
        return presenter
    }

    private val adapter: WordsAdapter
        get() = recyclerView.adapter as WordsAdapter

    companion object {
        fun getIntent(context: Context) = Intent(context, MainActivity::class.java)
    }
}
