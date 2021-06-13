package ru.otus.library.shell

import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod
import ru.otus.library.models.dto.BookCommentDto
import ru.otus.library.services.BookCommentService

@ShellComponent
class BookCommentCommands(
    private val service: BookCommentService
) {

    @ShellMethod(value = "Creating book comment command", key = ["cbc"])
    fun createBookComment(bookCommentDto: BookCommentDto): BookCommentDto =
        service.updateBookComment(bookCommentDto)

    @ShellMethod(value = "Reading book comment command", key = ["rbc"])
    fun findBookCommentById(bookCommentId: String): BookCommentDto? =
        service.findBookCommentById(bookCommentId)

    @ShellMethod(value = "Reading book comments command", key = ["rabc"])
    fun getAllBookComments(): List<BookCommentDto> =
        service.getAllBookComments()

    @ShellMethod(value = "Updating book comment command", key = ["ubc"])
    fun updateBookComment(bookCommentDto: BookCommentDto) {
        service.updateBookComment(bookCommentDto)
    }

    @ShellMethod(value = "Deleting book comment command", key = ["dbc"])
    fun deleteBookCommentById(bookCommentId: String) {
        service.deleteBookCommentById(bookCommentId)
    }
}