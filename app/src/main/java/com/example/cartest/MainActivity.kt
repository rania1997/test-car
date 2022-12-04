package com.example.cartest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        supportActionBar?.hide()
        Handler().postDelayed({
            val intent = Intent(this@MainActivity,LoginActivity::class.java)
            startActivity(intent)
        },5000)
       // val toolbar: Toolbar = findViewById(R.id.toolbar);
      //  setSupportActionBar(toolbar)
//        val signUpButton = findViewById<Button>(R.id.signup)
//
//        signUpButton.setOnClickListener{
//            val intent = Intent(this, LoginActivity::class.java)
//            startActivity(intent)
//        }

//        new Handler().postDelayed(new Runnable(){
//            @Override
//            public void run() {
//                startActivity( new Intent(MainActivity.this,LoginActivity.class));
//                finish();
//
//            }
//        },4000);

    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.menu,menu)
//        return true;
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when (item.itemId) {
//            R.id.quit -> Toast.makeText(this, "trying to quit", Toast.LENGTH_SHORT).show()
//          //  R.id.item2 -> Toast.makeText(this, "item2", Toast.LENGTH_SHORT).show()
//            else -> { // Note the block
//
//            }
//        }
//        return true
//    }
}