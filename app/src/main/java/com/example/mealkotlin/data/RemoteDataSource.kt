package com.example.mealkotlin.data

import com.example.mealkotlin.data.network.FoodApi
import com.example.mealkotlin.models.Categories
import com.example.mealkotlin.models.Ingredient
import com.example.mealkotlin.models.Meals
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val foodApi: FoodApi,
) {

    suspend fun getCategories(): Response<Categories> = foodApi.getCategories()

    suspend fun getMealsByCategoryName(categoryName: String): Response<Meals> =
        foodApi.getMealsByCategoryName(categoryName)

    suspend fun getIngredientMealByMealId(mealId: Int): Response<Ingredient> =
        foodApi.getMealIngredientByMealId(mealId)

    suspend fun getFilterByMeals(searchText: String): Response<Meals> =
        foodApi.getFilterByMeals(searchText)
}