package ru.otus.library.repositories

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import ru.otus.library.models.Author

@Repository
interface AuthorRepository : MongoRepository<Author, String>