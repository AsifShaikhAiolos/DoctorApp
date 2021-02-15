package com.twilio.video.docapp.auth

import android.content.Intent

sealed class LoginEvent {
    object GoogleLoginIntentRequestEvent : LoginEvent()
    data class EmailLoginEvent(val email: String, val password: String) : LoginEvent()
    data class GoogleLoginEvent(val signInResultIntent: Intent) : LoginEvent()
    data class CommunityLoginEvent(val identity: String, val passcode: String) : LoginEvent()
}
