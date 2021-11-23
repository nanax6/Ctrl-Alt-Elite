package com.example.natural_colombiapp


import com.google.gson.annotations.SerializedName

data class ParkItem(
    @SerializedName("desc")
    val desc: String,
    @SerializedName("imgUrl")
    val imgUrl: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("rating")
    val rating: String
)