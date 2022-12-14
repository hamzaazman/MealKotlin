package com.example.mealkotlin.models


import com.google.gson.annotations.SerializedName

data class Meal(
    @SerializedName("idMeal")
    val idMeal: Int,
    @SerializedName("strMeal")
    val mealName: String,
    @SerializedName("strMealThumb")
    val mealImage: String
)