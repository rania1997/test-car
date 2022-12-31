package com.example.cartest.datamodels

import com.google.gson.annotations.SerializedName

data class Car(
    @SerializedName("id") val id: Int?,
    @SerializedName("marque") val marque: String?,
    @SerializedName("miseEnCirculation") val miseEnCirculation: String?,
    @SerializedName("kilometrage") val kilometrage: String?,
)