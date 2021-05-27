package ru.otus.library.models

import javax.persistence.*

@Entity
@Table(name = "authors")
data class Author(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Int = 0,

    @Column
    val firstName: String = "",

    @Column
    val lastName: String = "",

    @Column
    val middleName: String? = null,

    @OneToMany(targetEntity = Book::class, cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    val books: List<Book>
)