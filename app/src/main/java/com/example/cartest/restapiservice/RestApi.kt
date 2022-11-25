package com.example.cartest.restapiservice

import com.example.cartest.datamodels.User
import retrofit2.Call
import retrofit2.http.*

interface RestApi {
    @Headers("Content-Type: application/json")
    @POST("user")
    fun addUser(@Body user: User): Call<User>
}