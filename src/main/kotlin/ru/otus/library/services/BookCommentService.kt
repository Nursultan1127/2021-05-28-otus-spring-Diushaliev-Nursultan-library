package ru.otus.library.services

import ru.otus.library.models.dto.BookCommentDto
import ru.otus.library.models.dto.BookDto

interface BookCommentService {

    fun updateBookComment(bookCommentDto: BookCommentDto): BookCommentDto

    fun findBookCommentById(bookCommentId: String): BookCommentDto?

    fun deleteBookCommentById(bookCommentId: String)

    fun getAllBookComments(): List<BookCommentDto>
}