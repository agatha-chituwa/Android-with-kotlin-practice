package com.example.lordhavemercy

import android.content.Intent
import android.content.SharedPreferences
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
    private lateinit var nameText: EditText
    private lateinit var ageText: EditText
    //shared preference variables
    private lateinit var sf: SharedPreferences
    private lateinit var editor:SharedPreferences.Editor




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);
        val greetingTextView = findViewById<TextView>(R.id.textView)
        nameText = findViewById(R.id.textField)
        ageText = findViewById(R.id.number)
        //initialize the shared preferece here
        sf = getSharedPreferences("my_sf", MODE_PRIVATE)
        editor = sf.edit()


    }

    override fun onPause() {
        super.onPause()
        //get user imput values
        val name = nameText.text.toString()
        val age = ageText.text.toString().toInt()
        editor.apply{
            putString("sf_name", name)
            putInt("sf_age", age)
            commit()
        }
    }

    override fun onResume() {
        super.onResume()
        val name = sf.getString("sf_name", null)
        val age = sf.getInt("sf_age", 0)
        nameText.setText(name)
        if(age != 0) {
            ageText.setText(age.toString())
        }
    }
}