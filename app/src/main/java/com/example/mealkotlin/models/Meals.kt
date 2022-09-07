package com.example.mealkotlin.models


import com.google.gson.annotations.SerializedName

data class Meals(
    @SerializedName("meals")
    val meals: List<Meal>
)