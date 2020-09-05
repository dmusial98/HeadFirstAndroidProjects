package com.example.headfirststoper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.core.os.HandlerCompat.postDelayed
import kotlinx.android.synthetic.*
import kotlinx.coroutines.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

class StopwatchActivity : AppCompatActivity() {

    private var seconds = 0
    private var running = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stopwatch)
        if(savedInstanceState != null)
        {
            seconds = savedInstanceState.getInt("seconds")
            running = savedInstanceState.getBoolean("running")
        }
        runTimer()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("seconds", seconds)
        outState.putBoolean("running", running)
    }

    public fun onClickStart(view: View) {
        running = true
    }

    public fun onClickStop(view: View) {
        running = false
    }

    public fun onClickReset(view: View) {
        running = false
        seconds = 0
    }

    private fun runTimer() {

          //wersja bez lambdy
        var timeView = findViewById<TextView>(R.id.time_view)
        var handler = Handler()
        val mRunnable = object : Runnable {
            override fun run() {
                val hours = seconds / 3600
                val minutes = (seconds % 3600) / 60
                val secs = seconds % 60
                val time = String.format("%d:%02d:%02d", hours, minutes, secs)
                timeView.text = time
                if (running) {
                    seconds++
                }
                handler.postDelayed(this, 1000)
            }
        }

        handler.post(mRunnable)

    }
}

