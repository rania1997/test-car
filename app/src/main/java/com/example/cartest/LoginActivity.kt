package com.example.cartest

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.cartest.restapiservice.ApiService
import com.example.cartest.restapiservice.UserService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    var emailEditText: EditText? = null
    var passwordEditText: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setSupportActionBar(findViewById(R.id.toolbar))

        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText = findViewById(R.id.passwordEditText)

        val button: Button = findViewById(R.id.button2)
        button.setOnClickListener {
            login()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_item, menu);
        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.signup -> {
                startActivity(Intent(this@LoginActivity, SignUpActivity::class.java))
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun login() {
        ApiService.userService.login(
            UserService.SignInBody(
                emailEditText!!.text.toString(),
                passwordEditText!!.text.toString(),
            )
        ).enqueue(
            object : Callback<UserService.MessageResponse> {
                override fun onResponse(
                    call: Call<UserService.MessageResponse>,
                    response: Response<UserService.MessageResponse>
                ) {
                    if (response.code() == 201) {
                        startActivity(Intent(this@LoginActivity, CarActivity::class.java))
                    } else {
                        MakeAlert().makeAlert(this@LoginActivity, "Warning", "Invalid credentials")
                        println("status code is " + response.code())
                    }
                }

                override fun onFailure(
                    call: Call<UserService.MessageResponse>,
                    t: Throwable
                ) {
                    println("HTTP ERROR")
                    t.printStackTrace()
                }
            }
        )
    }
}