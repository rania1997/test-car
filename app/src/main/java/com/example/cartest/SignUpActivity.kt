package com.example.cartest

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.cartest.datamodels.User
import com.example.cartest.restapiservice.ApiService
import com.example.cartest.restapiservice.UserService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        val nomEditText = findViewById<EditText>(R.id.nom);
        val prenomEditText = findViewById<EditText>(R.id.prenom)
        val emailEditText = findViewById<EditText>(R.id.email)
        val motDePasseEditText = findViewById<EditText>(R.id.motDePasse)
        val dateDeNaissanceEditText = findViewById<EditText>(R.id.dateDeNaissance)
        val adresseEditText = findViewById<EditText>(R.id.adresse)

        val signupButton = findViewById<Button>(R.id.signupbutton)

        signupButton.setOnClickListener {
            val user = User(
                id = null,
                nom = nomEditText.text.toString(),
                prenom = prenomEditText.text.toString(),
                email = emailEditText.text.toString(),
                motDePasse = motDePasseEditText.text.toString(),
                adresse = adresseEditText.text.toString(),
                dateDeNaissance = dateDeNaissanceEditText.text.toString()
            )
            System.out.println(user)
            addUser(user)
        }

        val textlinke = findViewById<TextView>(R.id.textView12);
        textlinke.setOnClickListener{
            val intent = Intent(this,LoginActivity ::class.java)
            startActivity(intent)
        }


    }

    fun addUser(user: User) {
        ApiService.userService.register(
            UserService.SignUpBody(
                    user.nom!!,
            user.prenom!!,
            user.email!!,
            user.motDePasse!!,
            user.adresse!!,
            user.dateDeNaissance!!,
        )
        ).enqueue(
            object : Callback<UserService.MessageResponse> {
                override fun onResponse(
                    call: Call<UserService.MessageResponse>,
                    response: Response<UserService.MessageResponse>
                ) {
                    if (response.code() == 201) {
                        finish()
                        val intent =
                            Intent(this@SignUpActivity, LoginActivity::class.java)
                        startActivity(intent)
                    } else {
                        MakeAlert().makeAlert(this@SignUpActivity, "Warning", "Please verify the informations")

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