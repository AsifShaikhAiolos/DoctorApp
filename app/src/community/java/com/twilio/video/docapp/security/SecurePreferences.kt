package com.twilio.video.docapp.security

interface SecurePreferences {

    fun putSecureString(key: String, value: String)

    fun getSecureString(key: String): String?
}
