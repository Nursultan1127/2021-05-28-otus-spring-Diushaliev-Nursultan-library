package ru.otus.library.services.impl

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.otus.library.models.Book
import ru.otus.library.models.dto.BookDto
import ru.otus.library.repositories.BookRepository
import ru.otus.library.services.BookService

@Service
class BookServiceImpl(
    private val repository: BookRepository
) : BookService {

    @Transactional
    override fun createBook(book: BookDto): Int =
        repository.createBook(book)

    override fun findBookById(bookId: Int): BookDto? =
        repository.findBookById(bookId)?.toDto()

    @Transactional
    override fun updateBook(book: BookDto) {
        repository.updateBook(book)
    }

    @Transactional
    override fun deleteBookById(bookId: Int) {
        repository.deleteBookById(bookId)
    }

    override fun getAllBooks(): List<BookDto> {
        return repository.getAllBooks().map { it.toDto() }
    }

    private fun Book.toDto() =
        BookDto(
            id = id,
            name = name,
            genreId = genreId,
            year = year,
            authorId= authorId
        )
}