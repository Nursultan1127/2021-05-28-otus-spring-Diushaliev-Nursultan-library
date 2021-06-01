package ru.otus.library.mappings

import ru.otus.library.models.BookComment
import ru.otus.library.models.dto.BookCommentDto

fun BookComment.toDto() =
    BookCommentDto(
        id = id,
        book = book.toDto(),
        comment = comment,
        commentedAt = commentedAt
    )

fun BookCommentDto.toEntity() =
    BookComment(
        id = id,
        book = book.toEntity(),
        comment = comment,
        commentedAt = commentedAt
    )