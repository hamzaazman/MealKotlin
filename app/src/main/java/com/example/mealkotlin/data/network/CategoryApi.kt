package com.example.mealkotlin.data.network

import com.example.mealkotlin.models.Categories
import retrofit2.Response
import retrofit2.http.GET

interface CategoryApi {

    @GET("categories.php")
    suspend fun getCategories(): Response<Categories>

}