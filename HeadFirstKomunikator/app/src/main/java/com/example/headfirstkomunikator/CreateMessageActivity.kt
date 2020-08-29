package com.example.headfirstkomunikator

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText

class CreateMessageActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_message)
    }


    public fun onSendMessage(view: View) {

        val messageView = findViewById<EditText>(R.id.message)
        var messageText = messageView.text.toString()

        //creating intent with content of current class and class to which message will be send
//        var intent = Intent(this, ReceiveMessageActivity::class.java)

        //putting content of message to intent
//        intent.putExtra(ReceiveMessageActivity.EXTRA_MESSAGE, messageText)

        val intent = Intent(Intent.ACTION_SEND)
        intent.setType("text/plain")
        intent.putExtra(Intent.EXTRA_TEXT, messageText)


        //excecution of intent
        startActivity(intent)


    }

}