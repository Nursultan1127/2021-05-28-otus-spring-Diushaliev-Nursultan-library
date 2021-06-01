package ru.otus.library.repositories.impl

import org.springframework.stereotype.Repository
import ru.otus.library.models.BookComment
import ru.otus.library.repositories.BookCommentRepository
import javax.persistence.EntityManager
import javax.persistence.TypedQuery

@Repository
class BookCommentRepositoryImpl(
    private val em: EntityManager
) : BookCommentRepository {

    override fun updateBookComment(bookComment: BookComment): BookComment {
        return if (bookComment.id == 0) {
            em.persist(bookComment)
            bookComment
        } else {
            em.merge(bookComment)
        }
    }

    override fun findBookCommentById(bookCommentId: Int): BookComment? =
        em.find(BookComment::class.java, bookCommentId)

    override fun deleteBookCommentById(bookCommentId: Int) {
        val query = em.createQuery("delete BookComment bс where bс.id = :bookCommentId")
        query.setParameter("bookCommentId", bookCommentId)
        query.executeUpdate()

        flushAndClear()
    }

    override fun getAllBookComments(): List<BookComment> {
        val query: TypedQuery<BookComment> = em.createQuery(
            "select bс from BookComment bс",
            BookComment::class.java)

        return query.resultList
    }

    private fun flushAndClear() {
        em.flush()
        em.clear()
    }
}