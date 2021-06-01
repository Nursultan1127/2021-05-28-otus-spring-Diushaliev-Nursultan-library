package ru.otus.library.models

import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "book_comments")
data class BookComment(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Int = 0,

    @Fetch(FetchMode.SELECT)
    @ManyToOne(targetEntity = Book::class, fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    val book: Book,

    @Column
    val comment: String,

    @Column
    val commentedAt: LocalDateTime = LocalDateTime.now()
)