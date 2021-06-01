package ru.otus.library.models

import javax.persistence.*

@Entity
@Table(name = "authors")
data class Author(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Int = 0,

    @Column
    val firstName: String,

    @Column
    val lastName: String,

    @Column
    val middleName: String? = null,

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    val books: List<Book> = emptyList()
)