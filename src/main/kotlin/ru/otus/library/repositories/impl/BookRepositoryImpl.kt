package ru.otus.library.repositories.impl

import org.springframework.stereotype.Repository
import ru.otus.library.models.Book
import ru.otus.library.repositories.BookRepository
import javax.persistence.EntityGraph
import javax.persistence.EntityManager
import javax.persistence.TypedQuery

@Repository
class BookRepositoryImpl(
    private val em: EntityManager
) : BookRepository {

    override fun updateBook(book: Book): Book {
        return if (book.id == 0) {
            em.persist(book)
            book
        } else {
            em.merge(book)
        }
    }

    override fun findBookById(bookId: Int): Book? =
        em.find(Book::class.java, bookId)


    override fun deleteBookById(bookId: Int) {
        val query = em.createQuery("delete Book b where b.id = :bookId")
            .setParameter("bookId", bookId)
            .executeUpdate()

        flushAndClear()
    }

    override fun getAllBooks(): List<Book> {
        val entityGraph: EntityGraph<*> = em.getEntityGraph("book-entity-graph")
        val query: TypedQuery<Book> = em.createQuery(
            "select b from Book b",
            Book::class.java)
            .setHint("javax.persistence.fetchgraph", entityGraph)

        return query.resultList
    }

    private fun flushAndClear() {
        em.flush()
        em.clear()
    }
}