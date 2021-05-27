package ru.otus.library.services.impl

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.otus.library.exceptions.NotFoundException
import ru.otus.library.models.Book
import ru.otus.library.models.BookComment
import ru.otus.library.models.dto.BookCommentDto
import ru.otus.library.models.dto.BookDto
import ru.otus.library.repositories.BookCommentRepository
import ru.otus.library.services.BookCommentService

@Service
class BookCommentServiceImpl(
    private val repository: BookCommentRepository
) : BookCommentService {

    @Transactional
    override fun updateBookComment(bookCommentDto: BookCommentDto): BookCommentDto {
        val bookComment = repository.updateBookComment(bookCommentDto.toEntity())
        return bookComment.toDto();
    }

    override fun findBookCommentById(bookCommentId: Int): BookCommentDto? =
        repository.findBookCommentById(bookCommentId)
            ?.toDto()
            ?: throw NotFoundException("BookComment with id $bookCommentId has not been found")

    @Transactional
    override fun deleteBookCommentById(bookCommentId: Int) {
        repository.deleteBookCommentById(bookCommentId)
    }

    override fun getAllBookComments(): List<BookCommentDto> =
        repository.getAllBookComments().map { it.toDto() }

    private fun BookComment.toDto() =
        BookCommentDto(
            id = id,
            comment = comment,
            commentedAt = commentedAt
        )

    private fun BookCommentDto.toEntity() =
        BookComment(
            id = id,
            comment = comment,
            commentedAt = commentedAt
        )
}