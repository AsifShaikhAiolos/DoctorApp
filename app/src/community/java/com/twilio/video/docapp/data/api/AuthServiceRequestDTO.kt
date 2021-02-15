package com.twilio.video.docapp.data.api

data class AuthServiceRequestDTO(
    val passcode: String? = null,
    val user_identity: String? = null,
    val room_name: String? = null
)
