package ru.otus.library.repositories

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import ru.otus.library.models.Book
import java.util.*

@Repository
interface BookRepository : MongoRepository<Book, Int> {

    fun findById(id: String): Optional<Book>

    fun deleteById(id: String)
}