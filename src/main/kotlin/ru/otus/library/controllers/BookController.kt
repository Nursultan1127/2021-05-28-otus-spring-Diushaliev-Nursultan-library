package ru.otus.library.controllers

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.otus.library.models.dto.BookDto
import ru.otus.library.services.BookService

@RestController
@RequestMapping("/books")
class BookController(
    private val bookService: BookService
) {

    @PostMapping
    fun createBook(@RequestBody book: BookDto): BookDto =
        bookService.updateBook(book)
}