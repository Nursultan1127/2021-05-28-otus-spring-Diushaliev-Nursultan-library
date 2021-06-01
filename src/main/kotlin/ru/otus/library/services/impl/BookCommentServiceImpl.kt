package ru.otus.library.services.impl

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.otus.library.exceptions.NotFoundException
import ru.otus.library.mappings.toDto
import ru.otus.library.mappings.toEntity
import ru.otus.library.models.dto.BookCommentDto
import ru.otus.library.repositories.BookCommentRepository
import ru.otus.library.services.BookCommentService

@Service
class BookCommentServiceImpl(
    private val repository: BookCommentRepository
) : BookCommentService {

    @Transactional
    override fun updateBookComment(bookCommentDto: BookCommentDto): BookCommentDto {
        val bookComment = repository.save(bookCommentDto.toEntity())
        return bookComment.toDto()
    }

    @Transactional(readOnly = true)
    override fun findBookCommentById(bookCommentId: Int): BookCommentDto =
        repository.findById(bookCommentId)
            .takeIf { it.isPresent }
            ?.get()
            ?.toDto()
            ?: throw NotFoundException("BookComment with id $bookCommentId has not been found")

    @Transactional
    override fun deleteBookCommentById(bookCommentId: Int) {
        repository.deleteById(bookCommentId)
    }

    @Transactional(readOnly = true)
    override fun getAllBookComments(): List<BookCommentDto> =
        repository.findAll()
            .map { it.toDto() }
}