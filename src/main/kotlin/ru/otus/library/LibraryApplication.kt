package ru.otus.library

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import ru.otus.library.models.Author
import ru.otus.library.models.Book
import ru.otus.library.models.Genre
import ru.otus.library.repositories.BookRepository

@SpringBootApplication
class LibraryApplication

fun main(args: Array<String>) {
    runApplication<LibraryApplication>(*args)
}

@Bean
fun runner(repository: BookRepository) = CommandLineRunner {

    val genre = Genre(name = "Romance")
    val author = Author(
        firstName = "Jerome",
        lastName = "Salinger",
        middleName = "David"
    )
    val book = Book(
        name = "The Catcher in the Rye",
        genre = genre,
        year = 1951,
        author = author
    )

    repository.insert(book)
}
