package by.arro.vocab.presentation.launch

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import by.arro.vocab.presentation.main.MainActivity

class LaunchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startActivity(MainActivity.getIntent(this))
        finish()
    }
}
