package ru.otus.library.repositories

import ru.otus.library.models.Book
import ru.otus.library.models.dto.BookDto

interface BookRepository {

    fun createBook(book: BookDto): Int

    fun findBookById(bookId: Int): Book?

    fun updateBook(book: BookDto)

    fun deleteBookById(bookId: Int)

    fun getAllBooks(): List<Book>
}