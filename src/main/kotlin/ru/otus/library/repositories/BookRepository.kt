package ru.otus.library.repositories

import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.otus.library.models.Book
import java.util.*

@Repository
interface BookRepository : JpaRepository<Book, Int> {

    @EntityGraph(value = "book-entity-graph")
    override fun findById(id: Int): Optional<Book>

    @EntityGraph(value = "book-entity-graph")
    override fun findAll(): List<Book>
}