package com.example.joshtalks.domain.model

data class ReadingPassage(
    val id: String,
    val text: String,
    val imageUrl: String? = null
)