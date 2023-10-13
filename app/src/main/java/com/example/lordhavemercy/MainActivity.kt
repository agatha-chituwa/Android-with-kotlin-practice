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

        //for login of the the button
        var emailview = findViewById<EditText>(R.id.email)
        var passwordview = findViewById<EditText>(R.id.password)
        val button2 = findViewById<Button>(R.id.button2)
        val display= findViewById<TextView>(R.id.textView2)

        //button event listener for button
        var email = ""
        var password = ""
        button2.setOnClickListener {
                   email = emailview.text.toString()
                   password = passwordview.text.toString()


            // then validation making sure email is entered and password as well
            if (email == "" || password == ""){


                Toast.makeText(
                    this@MainActivity,
                    "please enter your email/password",
                    Toast.LENGTH_SHORT).show()
            }else  {
                display.text = "hello dear your email is $email and password is $password"
                //to make sure after submission text is deleted in textfield
                emailview.text.clear()
                passwordview.text.clear()

            }
        }
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

        var car = Car()
        car.maxspeed = 170
        car.start()

        val driver = Driver("agatha")
        driver.showDetails()


        //navigate to the second activity
        next.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            if(email == "agathachituwa@gmail.com" && password == "12345678"){

                intent.putExtra("USER", enteredText)
                intent.putExtra("EMAIL", email)

                startActivity(intent)

            }

        }


    }

    override fun onRestart() {
        super.onRestart()
    }
}