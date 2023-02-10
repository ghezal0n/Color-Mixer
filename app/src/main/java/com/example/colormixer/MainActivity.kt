package com.example.colormixer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

    class MainActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            mixButton.setOnClickListener {
                val checkBox1 = checkBox1.isChecked //blue
                val checkBox2 = checkBox2.isChecked //red
                val checkBox3 = checkBox3.isChecked //yellow
                var selectedCheckboxes = 0
                if (checkBox1) selectedCheckboxes++
                if (checkBox2) selectedCheckboxes++
                if (checkBox3) selectedCheckboxes++

                if (selectedCheckboxes == 2) {
                    val selectedRadioButtonId = radioGroup.checkedRadioButtonId
                    if (selectedRadioButtonId != -1) {
                        val selectedRadioButton = findViewById<RadioButton>(selectedRadioButtonId)
                        val radioButtonText = selectedRadioButton.text.toString()
                        val intent = Intent(this, SecondActivity::class.java)
                        intent.putExtra("checkbox1", checkBox1)
                        intent.putExtra("checkbox2", checkBox2)
                        intent.putExtra("checkbox3", checkBox3)
                        intent.putExtra("radioButtonText", radioButtonText)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "Please select a radio button.", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "Please select exactly 2 checkboxes.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    class SecondActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity2)

            val checkBox1 = intent.getBooleanExtra("checkbox1", false)
            val checkBox2 = intent.getBooleanExtra("checkbox2", false)
            val checkBox3 = intent.getBooleanExtra("checkbox3", false)
            val radioButtonText = intent.getStringExtra("radioButtonText")

            // Add logic here to handle the chosen checkboxes and radio button
        }
    }

