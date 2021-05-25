package ru.otus.library.services

import ru.otus.library.models.dto.AggregateBookDto
import ru.otus.library.models.requests.BookUpdatingRequest

interface BookService {

    fun createBook(book: BookUpdatingRequest): Int

    fun findBookById(bookId: Int): AggregateBookDto?

    fun updateBook(book: BookUpdatingRequest)

    fun deleteBookById(bookId: Int)

    fun getAllBooks(): List<AggregateBookDto>
}