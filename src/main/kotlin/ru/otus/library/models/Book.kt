package ru.otus.library.models

import javax.persistence.*

@Entity
@Table(name = "books")
data class Book(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Int = 0,

    @Column
    val name: String = "",

    @Column
    val year: Int = 0,

    @OneToMany(targetEntity = BookComment::class, cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    val comments: List<BookComment> = emptyList()
)
