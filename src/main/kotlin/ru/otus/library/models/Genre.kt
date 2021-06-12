package ru.otus.library.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document


@Document(collection = "genres")
data class Genre(

    @Id
    val id: Int = 0,
    val name: String,
    val books: List<Book> = emptyList()
)