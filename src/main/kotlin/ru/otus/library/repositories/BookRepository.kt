package ru.otus.library.repositories

import ru.otus.library.models.Book


interface BookRepository {

    fun findBookById(bookId: Int): Book?

    fun updateBook(book: Book): Book

    fun deleteBookById(bookId: Int)

    fun getAllBooks(): List<Book>
}