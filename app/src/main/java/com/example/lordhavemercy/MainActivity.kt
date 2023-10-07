package com.example.lordhavemercy

import android.content.Intent
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val TAG = "MyActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);
        val greetingTextView = findViewById<TextView>(R.id.textView)
        val inputText = findViewById<EditText>(R.id.dbname)
        val button = findViewById<Button>(R.id.button)
        val next = findViewById<Button>(R.id.button3)
        var enteredText = ""
        button.setOnClickListener {
            enteredText = inputText.text.toString()
            if (enteredText == ""){
                next.visibility = INVISIBLE
                greetingTextView.text =""
                Toast.makeText(
                    this@MainActivity,
                    "please enter your name",
                    Toast.LENGTH_SHORT).show()
            }else {
                val message = "Welcome $enteredText"
                greetingTextView.text = message
                inputText.text.clear()
                next.visibility = VISIBLE
            }


        }

        //navigate to the second activity
        next.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("USER", enteredText)
            startActivity(intent)
        }


    }
}