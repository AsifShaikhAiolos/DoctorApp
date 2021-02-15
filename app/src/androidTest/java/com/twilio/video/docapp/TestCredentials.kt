package com.twilio.video.docapp

data class TestCredentials(
    val email_sign_in_user: EmailCredentials
)

data class EmailCredentials(
    val email: String,
    val password: String
)
