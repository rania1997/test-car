package com.example.cartest.restapiservice;

import com.example.cartest.cars.Car
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface CarService {

    data class CarsResponse(
        @SerializedName("cars")
        val cars: List<Car>
    )

    data class MessageResponse(
        val message: String
    )

    data class addBody(
        val marque: String,
        val miseEnCirculation: String,
        val kilometrage: String,
    )


    @GET("/car/getAll")
    fun getAll(): Call<CarsResponse>

    @POST("/car/add")
    fun register(@Body carBody: CarService.addBody): Call<CarService.MessageResponse>

}