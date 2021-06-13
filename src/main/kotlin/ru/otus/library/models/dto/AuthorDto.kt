package ru.otus.library.models.dto

data class AuthorDto(
    val id: String = "",
    val firstName: String,
    val lastName: String,
    val middleName: String? = null,
)