package ru.otus.library.models

data class Book(
    val id: Int,
    val name: String,
    val genreId: Int,
    val year: Int,
    val authorId: Int
)

data class AggregateBook(
    val id: Int,
    val name: String,
    val genreRu: String,
    val year: Int,
    val authorFullName: String
)