package ru.otus.library.services.impl

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.otus.library.exceptions.NotFoundException
import ru.otus.library.models.Book
import ru.otus.library.models.dto.BookDto
import ru.otus.library.repositories.BookRepository
import ru.otus.library.services.BookService

@Service
class BookServiceImpl(
    private val repository: BookRepository
) : BookService {

    @Transactional
    override fun updateBook(bookDto: BookDto): BookDto {
        val book = repository.updateBook(bookDto.toEntity())
        return book.toDto();
    }

    override fun findBookById(bookId: Int): BookDto? =
        repository.findBookById(bookId)
            ?.toDto()
            ?: throw NotFoundException("Book with id $bookId has not been found")

    @Transactional
    override fun deleteBookById(bookId: Int) {
        repository.deleteBookById(bookId)
    }

    override fun getAllBooks(): List<BookDto> =
         repository.getAllBooks().map { it.toDto() }


    private fun Book.toDto() =
        BookDto(
            id = id,
            name = name,
            year = year,
            comments = comments
        )

    private fun BookDto.toEntity() =
        Book(
            id = id,
            name = name,
            year = year,
            comments = comments
        )
}