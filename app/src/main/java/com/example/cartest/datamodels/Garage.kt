package com.example.cartest.datamodels

import com.google.gson.annotations.SerializedName

data class Garage (
    @SerializedName("lat") val lat: Double,
    @SerializedName("long") val long: Double
)