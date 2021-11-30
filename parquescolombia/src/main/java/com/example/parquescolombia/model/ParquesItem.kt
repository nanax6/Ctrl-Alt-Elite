package com.example.parquescolombia.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ParquesItem(
    @SerializedName("descripcion")
    val descripcion: String,
    @SerializedName("descripcionDetail")
    val descripcionDetail: String,
    @SerializedName("foto")
    val foto: String,
    @SerializedName("fotoDetail")
    val fotoDetail: String,
    @SerializedName("parqueNacional")
    val parqueNacional: String,
    @SerializedName("puntuacion")
    val puntuacion: Float,
    @SerializedName("ubicacion")
    val ubicacion: String,
    @SerializedName("temperatura")
    val temperatura: String,
    @SerializedName("sitios")
    val sitios: String

):  Serializable