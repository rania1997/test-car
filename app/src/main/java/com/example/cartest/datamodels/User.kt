package com.example.cartest.datamodels

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id") val id: Int?,
    @SerializedName("nom") val nom: String?,
    @SerializedName("prenom") val prenom: String?,
    @SerializedName("email") val email: String?,
    @SerializedName("motDePasse") val motDePasse: String?,
    @SerializedName("adresse") val adresse: String?,
    @SerializedName("dateDeNaissance") val dateDeNaissance: String?
)
