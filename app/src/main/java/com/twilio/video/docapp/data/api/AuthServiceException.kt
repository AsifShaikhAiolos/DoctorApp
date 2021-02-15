package com.twilio.video.docapp.data.api

class AuthServiceException(
    throwable: Throwable? = null,
    val error: AuthServiceError? = null,
    message: String? = null
) : RuntimeException(message, throwable)
