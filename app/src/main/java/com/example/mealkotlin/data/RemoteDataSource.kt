package com.example.mealkotlin.data

import com.example.mealkotlin.data.network.CategoryApi
import com.example.mealkotlin.models.Categories
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val categoryApi: CategoryApi
) {

    suspend fun getCategories(): Response<Categories> = categoryApi.getCategories()
}