package com.example.mealkotlin.data

import com.example.mealkotlin.data.network.FoodApi
import com.example.mealkotlin.models.Categories
import com.example.mealkotlin.models.Meals
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val categoryApi: FoodApi,
) {

    suspend fun getCategories(): Response<Categories> = categoryApi.getCategories()
    suspend fun getMealsByCategoryName(categoryName: String): Response<Meals> =
        categoryApi.getMealsByCategoryName(categoryName)
}