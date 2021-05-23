package ru.otus.library.models.dto

data class BookDto(
    val id: Int?,
    val name: String,
    val genreId: Int,
    val year: Int,
    val authorId: Int
)
