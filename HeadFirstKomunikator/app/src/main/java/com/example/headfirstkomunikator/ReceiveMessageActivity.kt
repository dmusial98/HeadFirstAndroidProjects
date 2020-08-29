package com.example.headfirstkomunikator

import android.app.Activity
import android.os.Bundle
import android.widget.TextView

class ReceiveMessageActivity : Activity() {

    companion object {
        public final val EXTRA_MESSAGE = "message"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receive_message)
        val intent = intent
        var messageText = intent.getStringExtra(EXTRA_MESSAGE)

        var messageView: TextView = findViewById<TextView>(R.id.message)
        messageView.text = messageText
    }



}