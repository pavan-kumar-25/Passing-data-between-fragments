package com.example.p6fragments

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity(), BlankFragment3.OnDataFromActivityListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        setupButtons()
    }

    private fun setupButtons() {
        val btnSubmit: Button = findViewById(R.id.submit_button)
//        val btnNext: Button = findViewById(R.id.btn_next)

        btnSubmit.setOnClickListener {
            val name = findViewById<EditText>(R.id.name_input).text.toString()
            val age = findViewById<EditText>(R.id.age_input).text.toString().toIntOrNull() ?: 0

            // Pass data to BlankFragment3
            val fragment = BlankFragment3.newInstance(name, age)
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
        }
//        btnNext.setOnClickListener {
//            // Start MainActivity2
//            startActivity(Intent(this, MainActivity3::class.java))
//        }
    }

    // Implement the method to handle data from BlankFragment3 if needed
    override fun onDataReceived(name: String, age: Int) {
        // Handle the received data here if needed
    }
}
