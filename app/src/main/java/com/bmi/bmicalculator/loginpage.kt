package com.bmi.bmicalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class loginpage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_loginpage)
     val email= findViewById<EditText>(R.id.edtemail)
        val password = findViewById<EditText>(R.id.edtpassword)

        var login = findViewById<Button>(R.id.btnlogin)
        val signup= findViewById<Button>(R.id.btnsignup)

        login.setOnClickListener{
            var strmail:String =email.text.toString()
            var strpass:String = password.text.toString()
            if (strmail.isNotEmpty() && strpass.isNotEmpty()) {
                Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,MainActivity::class.java))
            }
            else{
                Toast.makeText(this, "Username or Password is Not filled", Toast.LENGTH_SHORT).show()
            }


            signup.setOnClickListener{
                Toast.makeText(this, "Signup", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,signuppage::class.java))
            }
        }

    }
}