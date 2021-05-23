package ru.otus.library.shell

import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod
import ru.otus.library.models.dto.BookDto
import ru.otus.library.services.BookService

@ShellComponent
class BookCommands(
    private val service: BookService
) {

    @ShellMethod(value = "Creating book command", key = ["c", "create"])
    fun createBook(bookDto: BookDto): Int =
        service.createBook(bookDto)

    @ShellMethod(value = "Reading book command", key = ["r", "read"])
    fun findBookById(bookId: Int) =
        service.findBookById(bookId)

    @ShellMethod(value = "Reading books command", key = ["ra", "readAll"])
    fun getAllBooks(): List<BookDto> =
        service.getAllBooks()

    @ShellMethod(value = "Updating book command", key = ["u", "update"])
    fun updateBook(bookDto: BookDto) {
        service.updateBook(bookDto)
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