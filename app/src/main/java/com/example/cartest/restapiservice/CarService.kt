package com.example.cartest.restapiservice;

import com.example.cartest.cars.Car
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET

interface CarService {

    data class CarsResponse(
        @SerializedName("cars")
        val cars: List<Car>
    )

    @GET("/car")
    fun getAll(): Call<CarsResponse>
}