package ru.otus.library.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "authors")
data class Author(

    @Id
    val id: String = "",
    val firstName: String,
    val lastName: String,
    val middleName: String? = null,

    @DBRef
    val books: List<Book> = emptyList()
)