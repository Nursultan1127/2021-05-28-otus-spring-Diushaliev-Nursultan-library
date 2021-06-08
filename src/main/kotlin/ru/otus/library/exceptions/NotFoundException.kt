package ru.otus.library.exceptions

import java.time.LocalDateTime

class NotFoundException(override val message: String) : BaseException(
    message,
    LocalDateTime.now()
)