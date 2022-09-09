package com.example.mealkotlin.data.network

import com.example.mealkotlin.models.Categories
import com.example.mealkotlin.models.Ingredient
import com.example.mealkotlin.models.Meal
import com.example.mealkotlin.models.Meals
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FoodApi {

    @GET("categories.php")
    suspend fun getCategories(): Response<Categories>

    @GET("filter.php")
    suspend fun getMealsByCategoryName(
        @Query("c")
        categoryName: String
    ): Response<Meals>

    @GET("lookup.php")
    suspend fun getMealIngredientByMealId(
        @Query("i") mealId: Int
    ): Response<Ingredient>

    @GET("search.php")
    suspend fun getFilterByMeals(
        @Query("s") searchText: String
    ): Response<Meals>
}