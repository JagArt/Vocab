package by.arro.vocab.presentation.main

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import by.arro.vocab.R

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupPresenter()
    }

    override fun onDestroy() {
        presenter.destroy()
        super.onDestroy()
    }

    fun setupPresenter() {
        presenter = (lastCustomNonConfigurationInstance as MainPresenter?)?.apply {
            attach(this@MainActivity)
        } ?: MainPresenterImpl().apply {
            firstAttach(this@MainActivity)
        }
    }

    override fun onRetainCustomNonConfigurationInstance(): Any {
        return presenter
    }

    companion object {
        fun getIntent(context: Context) = Intent(context, MainActivity::class.java)
    }
}
