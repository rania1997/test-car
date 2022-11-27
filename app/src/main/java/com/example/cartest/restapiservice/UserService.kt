package com.example.cartest.restapiservice;

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserService {

    data class MessageResponse(
        val message: String
    )

    data class SignInBody(
        val email: String,
        val motDePasse: String,
    )

    data class SignUpBody(
        val nom: String,
        val prenom: String,
        val email: String,
        val motDePasse: String,
        val adresse: String,
        val dateDeNaissance: String,
    )

    @POST("/user/signin")
    fun login(@Body signinBody: SignInBody): Call<MessageResponse>

    @POST("/user/signup")
    fun register(@Body userBody: SignUpBody): Call<MessageResponse>
}