package com.example.mealkotlin.models

import com.google.gson.annotations.SerializedName

data class Ingredient(
    @SerializedName("meals")
    val mealDetails: List<MealDetail>
)