package ru.otus.library.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.otus.library.models.Genre

@Repository
interface GenreRepository : JpaRepository<Genre, Int>