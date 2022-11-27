package com.example.cartest.datamodels

import com.google.gson.annotations.SerializedName

data class Car(
    @SerializedName("id") val id: Int?,
    @SerializedName("marque") val nom: String?,
    @SerializedName("miseEnCirculation") val prenom: String?,
    @SerializedName("kilometrage") val email: String?,
)