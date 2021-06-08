package ru.otus.library.services

import ru.otus.library.models.dto.BookCommentDto
import ru.otus.library.models.dto.BookDto

interface BookService {

    fun updateBook(bookDto: BookDto): BookDto

    fun findBookById(bookId: Int): BookDto?

    fun deleteBookById(bookId: Int)

    fun getAllBooks(): List<BookDto>

    fun getAllBookComments(bookId: Int): List<BookCommentDto>
}