package ru.otus.library.mappings

import ru.otus.library.models.BookComment
import ru.otus.library.models.dto.BookCommentDto

fun BookComment.toDto() =
    BookCommentDto(
        id = id,
        bookId = bookId,
        comment = comment,
        commentedAt = commentedAt
    )

fun BookCommentDto.toEntity() =
    BookComment(
        id = id,
        bookId = bookId,
        comment = comment,
        commentedAt = commentedAt
    )