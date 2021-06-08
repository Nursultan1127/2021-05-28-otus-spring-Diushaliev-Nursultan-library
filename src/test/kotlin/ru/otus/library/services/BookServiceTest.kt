package ru.otus.library.services

import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import ru.otus.library.models.Author
import ru.otus.library.models.Book
import ru.otus.library.models.Genre
import ru.otus.library.models.dto.AuthorDto
import ru.otus.library.models.dto.BookDto
import ru.otus.library.models.dto.GenreDto
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

        val createdBookDto = service.updateBook(BOOK_DTO.copy(id = 0))
        Assertions.assertEquals(BOOK_DTO.id, createdBookDto.id)
        Assertions.assertEquals(BOOK_DTO.name, createdBookDto.name)
        Assertions.assertEquals(BOOK_DTO.genre, createdBookDto.genre)
        Assertions.assertEquals(BOOK_DTO.year, createdBookDto.year)
        Assertions.assertEquals(BOOK_DTO.author, createdBookDto.author)
        Assertions.assertEquals(BOOK_DTO.id, createdBookDto.id)
        Assertions.assertEquals(BOOK_DTO.name, createdBookDto.name)
        Assertions.assertEquals(BOOK_DTO.genre.id, createdBookDto.genre.id)
        Assertions.assertEquals(BOOK_DTO.genre.name, createdBookDto.genre.name)
        Assertions.assertEquals(BOOK_DTO.year, createdBookDto.year)
        Assertions.assertEquals(BOOK_DTO.author.id, createdBookDto.author.id)
        Assertions.assertEquals(BOOK_DTO.author.firstName, createdBookDto.author.firstName)
        Assertions.assertEquals(BOOK_DTO.author.lastName, createdBookDto.author.lastName)
    }

    @Test
    fun findBooById() {
        whenever(repository.findBookById(BOOK.id))
            .thenReturn(BOOK)

        val bookDto = service.findBookById(BOOK_DTO.id)
        Assertions.assertEquals(BOOK_DTO.id, bookDto!!.id)
        Assertions.assertEquals(BOOK_DTO.name, bookDto.name)
        Assertions.assertEquals(BOOK_DTO.genre, bookDto.genre)
        Assertions.assertEquals(BOOK_DTO.year, bookDto.year)
        Assertions.assertEquals(BOOK_DTO.author, bookDto.author)
    }

    @Test
    fun updateBook() {
        val updatedBook = BOOK.copy(name = "theBook")
        whenever(repository.updateBook(updatedBook))
            .thenReturn(updatedBook)

        val updatedBookDto = service.updateBook(BOOK_DTO.copy(name = "theBook"))
        Assertions.assertEquals(updatedBook.id, updatedBookDto.id)
        Assertions.assertEquals(updatedBook.name, updatedBookDto.name)
        Assertions.assertEquals(updatedBook.genre.id, updatedBookDto.genre.id)
        Assertions.assertEquals(updatedBook.genre.name, updatedBookDto.genre.name)
        Assertions.assertEquals(updatedBook.year, updatedBookDto.year)
        Assertions.assertEquals(updatedBook.author.id, updatedBookDto.author.id)
        Assertions.assertEquals(updatedBook.author.firstName, updatedBookDto.author.firstName)
        Assertions.assertEquals(updatedBook.author.lastName, updatedBookDto.author.lastName)
    }

    @Test
    fun deleteBookById() {
        service.deleteBookById(BOOK_DTO.id)
        verify(repository, times(1)).deleteBookById(BOOK.id)
    }

     companion object {
        val BOOK_DTO = BookDto(
            id = 1,
            name = "aBook",
            genre = GenreDto(1, "Genre"),
            year = 2021,
            author = AuthorDto(1, "FirstName", "LastName")
        )

        val BOOK = Book(
            id = 1,
            name = "aBook",
            year = 2021,
            genre = Genre(1, "Genre"),
            author = Author(1, "FirstName", "LastName")
        )
    }
}