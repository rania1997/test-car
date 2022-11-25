package com.example.cartest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import android.content.Intent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       // val toolbar: Toolbar = findViewById(R.id.toolbar);
      //  setSupportActionBar(toolbar)
        val signUpButton = findViewById<Button>(R.id.signup)

        signUpButton.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.quit -> Toast.makeText(this, "trying to quit", Toast.LENGTH_SHORT).show()
          //  R.id.item2 -> Toast.makeText(this, "item2", Toast.LENGTH_SHORT).show()
            else -> { // Note the block

            }
        }
        return true
    }
}