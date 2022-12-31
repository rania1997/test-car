package com.example.cartest

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.progressindicator.LinearProgressIndicator

class NotesVoitureActivity : AppCompatActivity() {

    var huileProgressBar: LinearProgressIndicator? = null
    var huileTextView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes_voiture)

        val km = intent.getIntExtra("km", 0);

        huileProgressBar = findViewById(R.id.huileProgressBar)
        huileTextView = findViewById(R.id.huileTextView)

        huileProgressBar!!.progress = km / 100
        huileTextView!!.text = km.toString() + " KM"
    }
}