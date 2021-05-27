package ru.otus.library.repositories

import ru.otus.library.models.BookComment

interface BookCommentRepository {

    fun updateBookComment(bookComment: BookComment): BookComment

    fun findBookCommentById(bookCommentId: Int): BookComment?

    fun deleteBookCommentById(bookCommentId: Int)

    fun getAllBookComments(): List<BookComment>
}