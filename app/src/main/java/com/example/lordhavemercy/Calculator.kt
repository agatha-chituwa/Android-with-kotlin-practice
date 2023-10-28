package com.example.lordhavemercy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Calculator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        //for now lets see for just two imput fields



        var one = findViewById<Button>(R.id.b1)
        var textview = findViewById<TextView>(R.id.textView3)
        one.setOnClickListener {
            textview.text = one.text.toString()
        }

        var two = findViewById<Button>(R.id.b2)
        two.setOnClickListener {
            textview.text = two.text.toString()
        }
        var plus = findViewById<Button>(R.id.bPlus)
        plus.setOnClickListener {
            textview.text = plus.text.toString()

        }
        var equals = findViewById<Button>(R.id.bEquals)
        equals.setOnClickListener {
            textview.text = equals.text.toString()

        }
//        one.setOnClickListener {
//            textview.append("1")
//
//        }

    }
}