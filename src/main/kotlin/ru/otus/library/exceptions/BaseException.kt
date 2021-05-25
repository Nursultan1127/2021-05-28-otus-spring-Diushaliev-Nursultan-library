package ru.otus.library.exceptions

import java.time.LocalDateTime

abstract class BaseException(
    override val message: String,
    val time: LocalDateTime
) : RuntimeException(message)