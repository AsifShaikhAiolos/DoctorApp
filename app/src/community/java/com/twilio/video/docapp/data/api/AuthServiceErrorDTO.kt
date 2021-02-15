package com.twilio.video.docapp.data.api

data class AuthServiceErrorDTO(
    val error: ErrorDTO? = null
)

data class ErrorDTO(
    val message: String? = null,
    val explanation: String? = null
)
