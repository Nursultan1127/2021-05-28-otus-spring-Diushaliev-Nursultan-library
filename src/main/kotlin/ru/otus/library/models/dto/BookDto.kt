package ru.otus.library.models.dto

import ru.otus.library.models.BookComment

data class BookDto(
    val id: Int,
    val name: String,
    val year: Int,
    val comments: List<BookComment>
)
