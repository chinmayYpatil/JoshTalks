package com.example.joshtalks.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.serialization.Serializable

@Serializable
data class ProductDto(
    val id: Int,
    val description: String,
    val thumbnail: String,
    val images: List<String> = emptyList()
)

@Serializable
data class ProductListResponse(
    val products: List<ProductDto>,
    val total: Int
)

class DummyJsonApi(
    private val client: HttpClient
) {
    private val BASE_URL = "https://dummyjson.com"

    suspend fun fetchProducts(): ProductListResponse {
        return client.get("$BASE_URL/products").body<ProductListResponse>()
    }
}