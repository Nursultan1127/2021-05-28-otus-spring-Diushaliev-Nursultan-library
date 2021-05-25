package ru.otus.library.services.impl

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.otus.library.exceptions.NotFoundException
import ru.otus.library.models.AggregateBook
import ru.otus.library.models.dto.AggregateBookDto
import ru.otus.library.models.requests.BookUpdatingRequest
import ru.otus.library.repositories.BookRepository
import ru.otus.library.services.BookService

@Service
class BookServiceImpl(
    private val repository: BookRepository
) : BookService {

    @Transactional
    override fun createBook(book: BookUpdatingRequest): Int =
        repository.createBook(book)

    override fun findBookById(bookId: Int): AggregateBookDto? =
        repository.findBookById(bookId)
            ?.toDto()
            ?: throw NotFoundException("Book with id $bookId has not been found")

    @Transactional
    override fun updateBook(book: BookUpdatingRequest) {
        repository.updateBook(book)
    }

    @Transactional
    override fun deleteBookById(bookId: Int) {
        repository.deleteBookById(bookId)
    }

    override fun getAllBooks(): List<AggregateBookDto> =
         repository.getAllBooks().map { it.toDto() }


    private fun AggregateBook.toDto() =
        AggregateBookDto(
            id = id,
            name = name,
            genreRu = genreRu,
            year = year,
            authorFullName = authorFullName
        )
}