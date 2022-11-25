package com.example.cartest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.cartest.datamodels.User
import com.example.cartest.restapiservice.RestApiService

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
                adresse = adresseEditText.text.toString() ,
                dateDeNaissance = dateDeNaissanceEditText.text.toString()
            )
            System.out.println(user)
            addUser(user)
        }

    }
    fun addUser(user:User) {
        val apiService = RestApiService()


        apiService.addUser(this, user) {
            Toast.makeText(this,"signing up... ", Toast.LENGTH_SHORT).show()

            if (it?.id != null) {
//                 it = newly added user parsed as response
//                 it?.id = newly added user ID
                Toast.makeText(this,"welcome "+it.prenom, Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this,"Username or Password wrong !!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}