package ru.otus.library.services.impl

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.otus.library.exceptions.NotFoundException
import ru.otus.library.mappings.toDto
import ru.otus.library.mappings.toEntity
import ru.otus.library.models.Author
import ru.otus.library.models.Book
import ru.otus.library.models.Genre
import ru.otus.library.models.dto.AuthorDto
import ru.otus.library.models.dto.BookDto
import ru.otus.library.models.dto.GenreDto
import ru.otus.library.repositories.BookRepository
import ru.otus.library.services.BookService

@Service
class BookServiceImpl(
    private val repository: BookRepository
) : BookService {

    @Transactional
    override fun updateBook(bookDto: BookDto): BookDto {
        val book = repository.updateBook(bookDto.toEntity())
        return book.toDto()
    }

    @Transactional(readOnly = true)
    override fun findBookById(bookId: Int): BookDto? =
        repository.findBookById(bookId)
            ?.toDto()
            ?: throw NotFoundException("Book with id $bookId has not been found")

    @Transactional
    override fun deleteBookById(bookId: Int) {
        repository.deleteBookById(bookId)
    }

    @Transactional(readOnly = true)
    override fun getAllBooks(): List<BookDto> =
         repository.getAllBooks().map { it.toDto() }

}