package ru.otus.library.services

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import ru.otus.library.models.Book
import ru.otus.library.models.dto.BookDto
import ru.otus.library.repositories.BookRepository
import ru.otus.library.services.impl.BookServiceImpl

@ExtendWith(MockitoExtension::class)
class BookServiceTest(

    @Mock
    private val repository: BookRepository
) {

    private val service = BookServiceImpl(repository)


    @Test
    fun createBook() {
        whenever(repository.updateBook(BOOK.copy(id = 0)))
            .thenReturn(BOOK)

        val createdBook = service.updateBook(BOOK_DTO.copy(id = 0))
        Assertions.assertEquals(BOOK_DTO.id, createdBook.id)
        Assertions.assertEquals(BOOK_DTO.name, createdBook.name)
        Assertions.assertEquals(BOOK_DTO.year, createdBook.year)
    }

    @Test
    fun findBooById() {
        whenever(repository.findBookById(BOOK.id))
            .thenReturn(BOOK)

        val bookDto = service.findBookById(BOOK_DTO.id)
        Assertions.assertEquals(BOOK_DTO.id, bookDto!!.id)
        Assertions.assertEquals(BOOK_DTO.name, bookDto.name)
        Assertions.assertEquals(BOOK_DTO.year, bookDto.year)
    }

    @Test
    fun updateBook() {
        val updatedBook = BOOK.copy(name = "theBook")
        whenever(repository.updateBook(updatedBook))
            .thenReturn(updatedBook)

        val createdBookDto = service.updateBook(BOOK_DTO.copy(name = "theBook"))
        Assertions.assertEquals(updatedBook.id, createdBookDto.id)
        Assertions.assertEquals(updatedBook.name, createdBookDto.name)
        Assertions.assertEquals(updatedBook.year, createdBookDto.year)
    }

    @Test
    fun deleteBookById() {
        service.deleteBookById(BOOK_DTO.id)
        verify(repository, times(1)).deleteBookById(BOOK.id)
    }

    private companion object {
        val BOOK_DTO = BookDto(
            id = 1,
            name = "aBook",
            year = 2021,
            comments = emptyList()
        )

        val BOOK = Book(
            id = 1,
            name = "aBook",
            year = 2021,
            comments = emptyList()
        )
    }
}