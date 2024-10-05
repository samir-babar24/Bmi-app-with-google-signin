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

class signuppage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signuppage)
        val user= findViewById<EditText>(R.id.edtuser)
        val email= findViewById<EditText>(R.id.edtsign_email)
        val pass= findViewById<EditText>(R.id.edtsign_password)
        val repass= findViewById<EditText>(R.id.edtsign_repassword)

        val singup= findViewById<Button>(R.id.btnsign)

        singup.setOnClickListener{
            val struser:String = user.text.toString()
            val strmail: String= email.text.toString()
            val strpass:String = pass.text.toString()
            val strrepass: String= repass.text.toString()

            if (strrepass.isNotEmpty() && struser.isNotEmpty() && strmail.isNotEmpty() && strrepass.isNotEmpty()){
                if (strpass.equals(strrepass)){
                    Toast.makeText(this, "successfully signup", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this,MainActivity::class.java))
                }
                else{
                    Toast.makeText(this, "Password is not same", Toast.LENGTH_SHORT).show()
                }
            }
            else{
                Toast.makeText(this, "All the Fields are Mandatory", Toast.LENGTH_SHORT).show()
            }

        }


    }
}