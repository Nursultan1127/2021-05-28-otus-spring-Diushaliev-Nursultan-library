package ru.otus.library.models.requests

data class BookUpdatingRequest(
    val id: Int?,
    val name: String,
    val genreId: Int,
    val year: Int,
    val authorId: Int
)