package ru.otus.library.models

import javax.persistence.*

@Entity
@Table(name = "genres")
data class Genre(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Int = 0,

    @Column
    val name: String,

    @OneToMany(mappedBy = "genre", fetch = FetchType.LAZY)
    val books: List<Book> = emptyList()
)