package com.example.p6fragments

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(), BlankFragment1.OnDataSubmittedListener {

    private var name: String = ""
    private var age: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        setupButtons()
    }

    private fun setupButtons() {
        val btn1: Button = findViewById(R.id.btn1)
        val btn2: Button = findViewById(R.id.btn2)
        val btnNext: Button = findViewById(R.id.btn_next)

        btn1.setOnClickListener {
            displayFragment(BlankFragment1())
        }

        btn2.setOnClickListener {
            // No need to create a bundle here, as the data is received through the interface method
            displayFragment(BlankFragment2.newInstance(name, age))
        }

        btnNext.setOnClickListener {
            // Start MainActivity2
            startActivity(Intent(this, MainActivity2::class.java))
        }
    }

    private fun displayFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    override fun onDataSubmitted(name: String, age: Int) {
        // Receive data from BlankFragment1
        // Store data in local variables
        this.name = name
        this.age = age
    }
}
