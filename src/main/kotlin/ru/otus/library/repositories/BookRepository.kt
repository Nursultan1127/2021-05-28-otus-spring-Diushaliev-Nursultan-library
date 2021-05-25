package ru.otus.library.repositories

import ru.otus.library.models.AggregateBook
import ru.otus.library.models.requests.BookUpdatingRequest

interface BookRepository {

    fun createBook(book: BookUpdatingRequest): Int

    fun findBookById(bookId: Int): AggregateBook?

    fun updateBook(book: BookUpdatingRequest)

    fun deleteBookById(bookId: Int)

    fun getAllBooks(): List<AggregateBook>
}