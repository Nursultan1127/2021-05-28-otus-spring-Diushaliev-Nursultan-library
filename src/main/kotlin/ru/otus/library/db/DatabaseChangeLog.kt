package ru.otus.library.db

import com.github.cloudyrock.mongock.ChangeLog
import com.github.cloudyrock.mongock.ChangeSet
import org.springframework.data.mongodb.core.MongoTemplate
import ru.otus.library.models.Author
import ru.otus.library.models.Book
import ru.otus.library.models.BookComment
import ru.otus.library.models.Genre

@ChangeLog
class DatabaseChangeLog(
//    private val bookRepository: BookRepository,
//    private val bookCommentRepository: BookCommentRepository
    private val mongoTemplate: MongoTemplate
) {

    @ChangeSet(order = "001", id = "1", author = "ruadun7")
    fun addBooks() {
        val genre1 = Genre(name = "Romance")
        val author1 = Author(
            firstName = "Jerome",
            lastName = "Salinger",
            middleName = "David"
        )
        val book1 = Book(
            id = "1",
            name = "The Catcher in the Rye",
            genre = genre1,
            year = 1951,
            author = author1
        )

        val genre2 = Genre(name = "Romance")
        val author2 = Author(
            firstName = "Jane",
            lastName = "Austen",
        )
        val book2 = Book(
            id = "2",
            name = "Pride and Prejudice",
            genre = genre2,
            year = 1813,
            author = author2
        )

        val books = listOf(book1, book2)
        mongoTemplate.insertAll(books)
    }

    @ChangeSet(order = "002", id = "2", author = "ruadun7")
    fun addBookComments() {
        val bookComment1 = BookComment(
            bookId = "1",
            comment = "My favorite book"
        )

        val bookComment2 = BookComment(
            bookId = "1",
            comment = "The Best"
        )


        mongoTemplate.insertAll(listOf(bookComment1, bookComment2))
    }
}