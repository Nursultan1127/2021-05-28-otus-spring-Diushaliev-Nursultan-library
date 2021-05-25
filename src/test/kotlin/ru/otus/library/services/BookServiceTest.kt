package ru.otus.library.services

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
        whenever(repository.createBook(BOOK_DTO))
            .thenReturn(BOOK_DTO.id)

        val createdId = service.createBook(BOOK_DTO)
        Assertions.assertEquals(BOOK_DTO.id, createdId)
    }

    @Test
    fun findBooById() {
        whenever(repository.findBookById(BOOK_DTO.id!!))
            .thenReturn(BOOK)

        val bookDto = service.findBookById(BOOK_DTO.id!!)
        Assertions.assertEquals(BOOK_DTO.id, bookDto!!.id)
        Assertions.assertEquals(BOOK_DTO.name, bookDto.name)
        Assertions.assertEquals(BOOK_DTO.genreId, bookDto.genreId)
        Assertions.assertEquals(BOOK_DTO.year, bookDto.year)
        Assertions.assertEquals(BOOK_DTO.authorId, bookDto.authorId)
    }

    @Test
    fun updateBook() {
        val updatedBookDto = BOOK_DTO.copy(name = "theBook")
        service.updateBook(updatedBookDto)

        verify(repository, times(1)).updateBook(updatedBookDto)
    }

    @Test
    fun deleteBookById() {
        service.deleteBookById(BOOK_DTO.id!!)
        verify(repository, times(1)).deleteBookById(BOOK_DTO.id!!)
    }

    private companion object {
        val BOOK_DTO = BookDto(
            id = 1,
            name = "aBook",
            genreId = 1,
            year = 2021,
            authorId = 1
        )

        val BOOK = Book(
            id = 1,
            name = "aBook",
            genreId = 1,
            year = 2021,
            authorId = 1
        )
    }
}