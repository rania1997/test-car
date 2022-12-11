package com.example.cartest

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class CarActivity : AppCompatActivity() {

    private var kilometrageEditText: EditText? = null
    private var submitButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car)

        kilometrageEditText = findViewById(R.id.kilometrageEditText)
        submitButton = findViewById(R.id.submitButton)

        submitButton!!.setOnClickListener {
            val intent = Intent(this@CarActivity, NotesVoitureActivity::class.java)
            intent.putExtra("km", kilometrageEditText!!.text.toString().toInt())
            startActivity(intent)
        }

        val nexButton = findViewById<Button>(R.id.buttonnext)
        nexButton!!.setOnClickListener {
            startActivity(Intent(this@CarActivity, MapActivity::class.java))
        }
    }
}