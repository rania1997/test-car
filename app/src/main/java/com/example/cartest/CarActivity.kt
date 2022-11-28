package com.example.cartest

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class CarActivity : AppCompatActivity() {

    var submitButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car)

        submitButton = findViewById(R.id.submitButton)
        submitButton!!.setOnClickListener {
            startActivity(Intent(this@CarActivity, TestCarActivity::class.java))
        }
    }
}