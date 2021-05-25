package ru.otus.library.shell

import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod
import ru.otus.library.models.dto.AggregateBookDto
import ru.otus.library.models.requests.BookUpdatingRequest
import ru.otus.library.services.BookService

@ShellComponent
class BookCommands(
    private val service: BookService
) {

    @ShellMethod(value = "Creating book command", key = ["c", "create"])
    fun createBook(book: BookUpdatingRequest): Int =
        service.createBook(book)

    @ShellMethod(value = "Reading book command", key = ["r", "read"])
    fun findBookById(bookId: Int): AggregateBookDto? =
        service.findBookById(bookId)

    @ShellMethod(value = "Reading books command", key = ["ra", "readAll"])
    fun getAllBooks(): List<AggregateBookDto> =
        service.getAllBooks()

    @ShellMethod(value = "Updating book command", key = ["u", "update"])
    fun updateBook(book: BookUpdatingRequest) {
        service.updateBook(book)
    }

    @ShellMethod(value = "Deleting book command", key = ["d", "delete"])
    fun deleteBookById(bookId: Int) {
        service.deleteBookById(bookId)
    }

    @ShellMethod("Add two integers together.")
    fun add(a: Int, b: Int): Int {
        return a + b
    }
}