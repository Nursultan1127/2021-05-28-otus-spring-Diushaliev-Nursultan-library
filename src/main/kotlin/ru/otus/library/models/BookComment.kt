package ru.otus.library.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document(collection = "book_comments")
data class BookComment(

    @Id
    val id: Int = 0,
    val book: Book,
    val comment: String,
    val commentedAt: LocalDateTime = LocalDateTime.now()
)