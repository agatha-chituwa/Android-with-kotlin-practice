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
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);
        val weightText = findViewById<EditText>(R.id.etweight)
        val heighText = findViewById<EditText>(R.id.etHeight)
        val btncalculate = findViewById<Button>(R.id.btnCalculate)

        btncalculate.setOnClickListener {
            //get weight and height in string format

            val weight = weightText.text.toString()
            val height = heighText.text.toString()
            if (validateinput(weight, height)) {
                val bmi = weight.toFloat() / ((height.toFloat() / 100) * (height.toFloat() / 100))

                //two decimal places
                val bmi2 = String.format("%.2f", bmi).toFloat()
                displayResults(bmi2)
            }
        }

    }

    private  fun validateinput(weight:String?, height:String? ): Boolean{
        return when{
            weight.isNullOrEmpty() -> {
                Toast.makeText(this, "weight is empty",Toast.LENGTH_LONG).show()
                return false
            }
            height.isNullOrEmpty() -> {
                Toast.makeText(this, "height is empty",Toast.LENGTH_LONG).show()
                return false
            }else ->{
                return true
            }
        }
    }
    private fun displayResults(bmi:Float){
        val resultIndex = findViewById<TextView>(R.id.tvindex)
        val resultDescription = findViewById<TextView>(R.id.tvResult)
        val info = findViewById<TextView>(R.id.tvinfo)

        //display bmi value
        resultIndex.text = bmi.toString()
        info.text = "normal range is 18.5 - 24.9"

        var resultText = ""
        var color = 0
        when{
            bmi< 18.50->{
                resultText = "underWeight"
                color = R.color.under_weight
            }
            bmi in 18.50..24.99 ->{
                resultText = "Normal and healthy"
                color = R.color.normal
            }
            bmi in 25.00..29.99 ->{
                resultText = "overweight"
                color = R.color.over_weight
            }
            bmi >29.99 ->{
                resultText = "Obese"
                color = R.color.obese
            }
        }

        resultDescription.setTextColor(ContextCompat.getColor(this, color))
        resultDescription.text = resultText

    }

}