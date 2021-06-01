package ru.otus.library.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.otus.library.models.BookComment

@Repository
interface BookCommentRepository : JpaRepository<BookComment, Int>