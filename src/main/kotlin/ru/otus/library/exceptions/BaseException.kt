package ru.otus.library.exceptions

import org.springframework.http.HttpStatus
import java.time.LocalDateTime

abstract class BaseException(
    val httpStatus: HttpStatus,
    override val message: String,
    val time: LocalDateTime
) : RuntimeException(message)