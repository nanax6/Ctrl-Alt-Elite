package com.example.natural_colombiapp


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ParkItem(
    @SerializedName("desc")
    val desc: String,
    @SerializedName("descDetail")
    val descDetail: String,
    @SerializedName("imgUrl")
    val imgUrl: String,
    @SerializedName("imgUrlDetail")
    val imgUrlDetail: String,
    @SerializedName("loc")
    val loc: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("rating")
    val rating: String,
    @SerializedName("relSites")
    val relSites: String,
    @SerializedName("temp")
    val temp: String
):  Serializable