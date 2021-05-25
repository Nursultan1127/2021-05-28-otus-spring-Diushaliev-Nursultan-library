package ru.otus.library.repositories.impl

import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations
import org.springframework.jdbc.support.GeneratedKeyHolder
import org.springframework.stereotype.Repository
import ru.otus.library.models.AggregateBook
import ru.otus.library.models.Book
import ru.otus.library.models.requests.BookUpdatingRequest
import ru.otus.library.repositories.BookRepository
import java.sql.ResultSet

@Repository
class BookRepositoryImpl(
    private val namedParameterJdbcOperations: NamedParameterJdbcOperations

) : BookRepository {
    override fun createBook(book: BookUpdatingRequest): Int {
        val keyHolder = GeneratedKeyHolder()
        val params = MapSqlParameterSource(
            mapOf(
                "name" to book.name,
                "genre_id" to book.genreId,
                "year" to book.year,
                "author_id" to book.authorId
            )
        )
        namedParameterJdbcOperations.update(
            SQL_INSERT_BOOK,
            params,
            keyHolder
        )
        return keyHolder.key as Int
    }

    override fun findBookById(bookId: Int): AggregateBook? =
        namedParameterJdbcOperations.query(
            SQL_FIND_BOOK_BY_ID,
            mapOf("bookId" to bookId),
            AGGREGATE_BOOK_ROW_MAPPER
        )
            .firstOrNull()

    override fun updateBook(book: BookUpdatingRequest) {
        namedParameterJdbcOperations.update(
            SQL_UPDATE_BOOK_BY_ID,
            mapOf(
                "name" to book.name,
                "genre_id" to book.genreId,
                "year" to book.year,
                "author_id" to book.authorId,
                "bookId" to book.id
            )
        )
    }

    override fun deleteBookById(bookId: Int) {
        namedParameterJdbcOperations.update(
            "delete from books as b where b.id = :bookId",
            mapOf("bookId" to bookId)
        )
    }

    override fun getAllBooks(): List<AggregateBook> =
        namedParameterJdbcOperations.query(
            SQL_GET_ALL_BOOKS,
            AGGREGATE_BOOK_ROW_MAPPER
        )

    private companion object {

        const val SQL_INSERT_BOOK = """
            insert into books (name, 
                               genre_id, 
                               year, 
                               author_id)
                values (:name, 
                        :genre_id, 
                        :year, 
                        :author_id)
        """

        const val SQL_GET_ALL_BOOKS = """
            select b.id, 
                   b.name, 
                   g.name_ru, 
                   b.year,
                   concat(a.first_name, ' ', a.last_name) as author_full_name
            from books as b
            join genres as g on b.genre_id = g.id
            join authors as a on b.author_id = a.id
        """

        const val SQL_FIND_BOOK_BY_ID = "$SQL_GET_ALL_BOOKS where b.id = :bookId"

        const val SQL_UPDATE_BOOK_BY_ID = """
            update books set 
                name = :name,
                genre_id = :genre_id,
                year = :year,
                author_id = :author_id
                
            where id = :bookId
        """

        val BOOK_ROW_MAPPER = RowMapper { rs: ResultSet, _: Int ->
            Book(
                id = rs.getInt("id"),
                name = rs.getString("name"),
                genreId = rs.getInt("genre_id"),
                year = rs.getInt("year"),
                authorId = rs.getInt("author_id")
            )
        }

        val AGGREGATE_BOOK_ROW_MAPPER = RowMapper { rs: ResultSet, _: Int ->
            AggregateBook(
                id = rs.getInt("id"),
                name = rs.getString("name"),
                genreRu = rs.getString("name_ru"),
                year = rs.getInt("year"),
                authorFullName = rs.getString("author_full_name")
            )
        }
    }
}