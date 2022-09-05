package com.example.mealkotlin.models


import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("idCategory")
    val id: String,
    @SerializedName("strCategory")
    val categoryName: String,
    @SerializedName("strCategoryDescription")
    val categoryDescription: String,
    @SerializedName("strCategoryThumb")
    val categoryImage: String
)