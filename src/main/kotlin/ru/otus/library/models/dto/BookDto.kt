package ru.otus.library.models.dto

data class BookDto(
    val id: Int,
    val name: String,
    val genre: GenreDto,
    val year: Int,
    val author: AuthorDto
)
