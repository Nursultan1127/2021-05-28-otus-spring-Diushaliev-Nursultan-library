package ru.otus.library.models

data class Author(
    private val id: Int,
    private val firstName: String,
    private val lastName: String,
    private val middleName: String?
)