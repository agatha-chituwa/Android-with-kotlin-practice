package com.example.lordhavemercy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)
        var username = intent.getStringExtra("USER")
        var email= intent.getStringExtra("EMAIL")
        var textView = findViewById<TextView>(R.id.textView)
        var message = "$username, you are logged in using the email $email"
        textView.text = message

    }
}