package ru.otus.library.services

import ru.otus.library.models.dto.BookDto

interface BookService {

    fun createBook(book: BookDto): Int

    fun findBookById(bookId: Int): BookDto?

    fun updateBook(book: BookDto)

    fun deleteBookById(bookId: Int)

    fun getAllBooks(): List<BookDto>
}