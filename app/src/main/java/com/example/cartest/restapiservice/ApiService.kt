package com.example.cartest.restapiservice

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {

    private fun retrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://192.168.1.59:3000/")
            .build()
    }

    val userService: UserService by lazy {
        retrofit().create(UserService::class.java)
    }

    val carService: CarService by lazy {
        retrofit().create(CarService::class.java)
    }

}