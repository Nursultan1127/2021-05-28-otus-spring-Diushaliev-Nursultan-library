package ru.otus.library.models

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "book_comments")
data class BookComment(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Int = 0,

    @Column
    val comment: String = "",

    @Column
    val commentedAt: LocalDateTime = LocalDateTime.now()
)