package ru.otus.library.models.dto

data class AuthorDto(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val middleName: String? = null,
)