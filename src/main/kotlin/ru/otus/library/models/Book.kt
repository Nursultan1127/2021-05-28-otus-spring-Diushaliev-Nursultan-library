package ru.otus.library.models

import ru.otus.library.exceptions.UnknownGenreException

data class Book(
    val id: Int,
    val name: String,
    val genreId: Int,
    val year: Int,
    val authorId: Int
)

enum class Genre(val text: String) {
    FANTASY("фэнтези"),
    SCI_FI("научная фантастика"),
    MYSTERY("таинственное"),
    THRILLER("триллер"),
    ROMANCE("роман"),
    WESTERNS("вестерны"),
    DYSTOPIAN("антиутопия"),
    CONTEMPORARY("современное");


    companion object {
        private val mappingByText = values().associateBy { it.text }

        fun getByText(text: String) =
            mappingByText[text] ?: throw UnknownGenreException(text)
    }
}