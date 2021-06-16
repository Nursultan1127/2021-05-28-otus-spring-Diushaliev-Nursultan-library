package ru.otus.library.models

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document(collection = "book_comments")
data class BookComment(
    @Id
    val id: String = "",

    @DBRef
    val bookId: String,

    val comment: String,
    val commentedAt: LocalDateTime = LocalDateTime.now()
)