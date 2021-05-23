package ru.otus.library.exceptions

import org.springframework.http.HttpStatus
import java.time.LocalDateTime

class UnknownGenreException(text: String) : BaseException(
    HttpStatus.BAD_REQUEST,
    text,
    LocalDateTime.now()
)
