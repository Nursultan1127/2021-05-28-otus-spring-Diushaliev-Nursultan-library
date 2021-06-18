package ru.otus.library.models.dto

import java.time.LocalDateTime

data class BookCommentDto(
    val id: String = "",
    val bookId: String,
    val comment: String,
    val commentedAt: LocalDateTime = LocalDateTime.now()
)