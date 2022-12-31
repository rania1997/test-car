package com.example.cartest.restapiservice

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {

    private fun retrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://172.21.112.1:3000/")
            .build()
    }

    val userService: UserService by lazy {
        retrofit().create(UserService::class.java)
    }

    val carService: CarService by lazy {
        retrofit().create(CarService::class.java)
    }

}