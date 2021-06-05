package ru.otus.library.models

import javax.persistence.*

@Entity
@Table(name = "books")
@NamedEntityGraph(
    name = "book-entity-graph",
    attributeNodes = [NamedAttributeNode("genre"),
                      NamedAttributeNode("author"),
                      NamedAttributeNode("comments")
    ]
)
data class Book(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Int = 0,

    @Column
    val name: String,

    @ManyToOne(targetEntity = Genre::class, fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id")
    val genre: Genre,

    @Column
    val year: Int,

    @ManyToOne(targetEntity = Author::class, fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    val author: Author,

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    val comments: List<BookComment> = emptyList()
)
