package ru.otus.library.models.dto

data class BookDto(
    val id: Int?,
    val name: String,
    val genre: String,
    val year: Int,
    val author: String
)

data class AggregateBookDto(
    val id: Int,
    val name: String,
    val genreRu: String,
    val year: Int,
    val authorFullName: String
)
