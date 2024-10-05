package com.bmi.bmicalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var weightEditText: EditText
    private lateinit var heightEditText: EditText
    private lateinit var calculateButton: Button
    private lateinit var resultTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        weightEditText = findViewById(R.id.weight)
        heightEditText = findViewById(R.id.heightEdit)
        calculateButton = findViewById(R.id.calculatebtn)
        resultTextView = findViewById(R.id.resultText)

        calculateButton.setOnClickListener {
            calculateBMI()
        }
    }

    private fun calculateBMI() {
        val weightStr = weightEditText.text.toString()
        val heightStr = heightEditText.text.toString()

        if (weightStr.isEmpty() || heightStr.isEmpty()) {
            Toast.makeText(this, "Please enter both weight and height", Toast.LENGTH_SHORT).show()
            return
        }

        val weight = weightStr.toFloat()
        val height = heightStr.toFloat() / 100  // Convert height from cm to meters

        val bmi = weight / (height * height)

        resultTextView.text = String.format("Your BMI is %.2f", bmi)

        // Optional: Show a message based on the BMI value
        when {
            bmi < 18.5 -> resultTextView.append("\nUnderweight")
            bmi in 18.5..24.9 -> resultTextView.append("\nNormal weight")
            bmi in 25.0..29.9 -> resultTextView.append("\nOverweight")
            else -> resultTextView.append("\nObesity")
        }

    }
}