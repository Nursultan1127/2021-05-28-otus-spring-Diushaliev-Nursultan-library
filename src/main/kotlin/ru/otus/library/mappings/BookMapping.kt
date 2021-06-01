package ru.otus.library.mappings

import ru.otus.library.models.Author
import ru.otus.library.models.Book
import ru.otus.library.models.Genre
import ru.otus.library.models.dto.AuthorDto
import ru.otus.library.models.dto.BookDto
import ru.otus.library.models.dto.GenreDto

fun Book.toDto() =
    BookDto(
        id = id,
        name = name,
        genre = GenreDto(
            genre.id,
            genre.name
        ),
        year = year,
        author = AuthorDto(
            author.id,
            author.firstName,
            author.lastName,
            author.middleName
        )
    )

fun BookDto.toEntity() =
    Book(
        id = id,
        name = name,
        genre = Genre(
            genre.id,
            genre.name
        ),
        year = year,
        author = Author(
            author.id,
            author.firstName,
            author.lastName,
            author.middleName
        )
    )