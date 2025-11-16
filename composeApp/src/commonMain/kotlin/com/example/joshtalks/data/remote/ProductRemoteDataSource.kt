package com.example.joshtalks.data.remote

import com.example.joshtalks.domain.model.ReadingPassage

class ProductRemoteDataSource(
    private val api: DummyJsonApi
) {
    suspend fun getReadingPassage(): ReadingPassage {
        val response = api.fetchProducts()

        val product = response.products.randomOrNull()
            ?: throw IllegalStateException("No products available from API for reading task.")

        val imageUrl = product.images.firstOrNull() ?: product.thumbnail

        return ReadingPassage(
            id = product.id.toString(),
            text = product.description,
            imageUrl = imageUrl
        )
    }
}