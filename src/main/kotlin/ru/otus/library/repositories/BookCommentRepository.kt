package ru.otus.library.repositories

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import ru.otus.library.models.BookComment
import java.util.*

@Repository
interface BookCommentRepository : MongoRepository<BookComment, Int> {

    fun findById(id: String): Optional<BookComment>

    fun deleteById(id: String)
}