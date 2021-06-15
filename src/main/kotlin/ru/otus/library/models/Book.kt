package ru.otus.library.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document("books")
data class Book(
    @Id
    val id: String = "",
    val name: String,
    val genre: Genre,
    val year: Int,
    val author: Author
)
