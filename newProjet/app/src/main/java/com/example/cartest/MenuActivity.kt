package com.example.cartest

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MenuActivity  : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        setSupportActionBar(findViewById(R.id.toolbar))

        val ajouButton = findViewById<Button>(R.id.buttontest)
        ajouButton!!.setOnClickListener {
            startActivity(Intent(this@MenuActivity,CarActivity::class.java))
        }

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_item, menu);
        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.map -> {
                startActivity(Intent(this@MenuActivity, MapActivity::class.java))
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}