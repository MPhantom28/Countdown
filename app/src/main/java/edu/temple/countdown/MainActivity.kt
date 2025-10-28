package edu.temple.countdown

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    val countdownHandler = Handler(Looper.getMainLooper()) {
        countdownTextView.text = it.what.toString()
        true
    }

    val countdownTextView : TextView by lazy {
        findViewById(R.id.textView)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Thread {
            repeat(100) {
                val countdown = 100 - it
                Log.d("Countdown", countdown.toString())
                //countdownTextView.text = countdown

                countdownHandler.sendEmptyMessage(countdown)

                Thread.sleep(1000)
            }
        }.start()


    }
}