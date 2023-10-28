package com.example.lordhavemercy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class SimpleCalculator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_calculator)

        //just getting views ofcouse
        val firstNumber = findViewById<EditText>(R.id.num1)
        val secondNumber = findViewById<EditText>(R.id.num2)

        val plus = findViewById<Button>(R.id.plus)
        val times = findViewById<Button>(R.id.times)
        val minus = findViewById<Button>(R.id.minus)
        val divide = findViewById<Button>(R.id.divide)


        //getting the value from the first input and keeping it
        //for this to work you need to have starting numbers okay
        //we will be done today right?
        //for thi im just targeting the numbers entered


//for addition
        plus.setOnClickListener {
            val first = firstNumber.text.toString()
            val second = secondNumber.text.toString()


            if (validateinput(first, second) && isNumeric(first) && isNumeric(second)) {
                val number2 = second.toDouble()
                val number1 = first.toDouble()
                addition(number1, number2)

            }


        }

        //for times
        times.setOnClickListener {
            val first = firstNumber.text.toString()
            val second = secondNumber.text.toString()


            if (validateinput(first, second) && isNumeric(first) && isNumeric(second)) {
                val number2 = second.toDouble()
                val number1 = first.toDouble()
                times(number1, number2)

            }


        }
        //for minus
        minus.setOnClickListener {
            val first = firstNumber.text.toString()
            val second = secondNumber.text.toString()


            if (validateinput(first, second) && isNumeric(first) && isNumeric(second)) {
                val number2 = second.toDouble()
                val number1 = first.toDouble()
                minus(number1, number2)

            }


        }
        //for divide
        divide.setOnClickListener {
            val first = firstNumber.text.toString()
            val second = secondNumber.text.toString()


            if (validateinput(first, second) && isNumeric(first) && isNumeric(second)) {
                val number2 = second.toDouble()
                val number1 = first.toDouble()
                divide(number1, number2)

            }


        }





    }
    fun isNumeric(toCheck: String): Boolean {
        return toCheck.all { char -> char.isDigit() }
    }
    private  fun validateinput(weight:String?, height:String? ): Boolean{
        return when{
            weight.isNullOrEmpty() -> {
                Toast.makeText(this, "enter a number", Toast.LENGTH_LONG).show()
                return false
            }
            height.isNullOrEmpty() -> {
                Toast.makeText(this, "enter a number", Toast.LENGTH_LONG).show()
                return false
            }else ->{
                return true
            }
        }
    }

    fun addition (a:Double, b:Double) {
        val result = findViewById<TextView>(R.id.results)
        val results = a + b
        result.text = results.toString()
    }

    fun times (a:Double, b:Double) {
        val result = findViewById<TextView>(R.id.results)
        val results = a * b
        result.text = results.toString()
    }
    fun minus (a:Double, b:Double) {
        val result = findViewById<TextView>(R.id.results)
        val results = a - b
        result.text = results.toString()
    }
    fun divide (a:Double, b:Double) {
        val result = findViewById<TextView>(R.id.results)
        if (b > 0){
            val results = a / b
            result.text = results.toString()
        } else{
            Toast.makeText(this, "the number should be greater than zero", Toast.LENGTH_LONG).show()
        }


    }


}