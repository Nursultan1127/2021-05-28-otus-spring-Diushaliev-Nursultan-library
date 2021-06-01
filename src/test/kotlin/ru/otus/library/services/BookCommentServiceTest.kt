package ru.otus.library.services

import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import ru.otus.library.models.BookComment
import ru.otus.library.models.dto.BookCommentDto
import ru.otus.library.repositories.BookCommentRepository
import ru.otus.library.services.impl.BookCommentServiceImpl

@ExtendWith(MockitoExtension::class)
class BookCommentServiceTest(
    @Mock
    private val repository: BookCommentRepository
) {

    private val service = BookCommentServiceImpl(repository)

    @Test
    fun findBookCommentById() {
        whenever(repository.findBookCommentById(BOOK_COMMENT.id))
            .thenReturn(BOOK_COMMENT)

        val bookCommentDto = service.findBookCommentById(BOOK_COMMENT_DTO.id)
        Assertions.assertEquals(BOOK_COMMENT_DTO.id, bookCommentDto!!.id)
        Assertions.assertEquals(BOOK_COMMENT_DTO.comment, bookCommentDto.comment)
    }

    @Test
    fun deleteBookCommentById() {
        service.deleteBookCommentById(BOOK_COMMENT_DTO.id)
        verify(repository, times(1)).deleteBookCommentById(BOOK_COMMENT.id)
    }

    private companion object {
        val BOOK_COMMENT_DTO = BookCommentDto(
            id = 1,
            comment = "Hello World!"
        )

        val BOOK_COMMENT = BookComment(
            id = 1,
            comment = "Hello World!"
        )
    }
}