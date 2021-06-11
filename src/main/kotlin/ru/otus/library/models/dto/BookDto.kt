package ru.otus.library.models.dto

import ru.otus.library.models.BookComment

data class BookDto(
    val id: Int,
    val name: String,
    val genre: GenreDto,
    val year: Int,
    val author: AuthorDto,
    val comments: List<BookComment> = emptyList()
)
