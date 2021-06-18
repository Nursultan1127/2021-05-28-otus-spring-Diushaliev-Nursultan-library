package ru.otus.library.services

import ru.otus.library.models.dto.BookDto

interface BookService {

    fun updateBook(bookDto: BookDto): BookDto

    fun findBookById(bookId: String): BookDto

    fun deleteBookById(bookId: String)

    fun getAllBooks(): List<BookDto>
}