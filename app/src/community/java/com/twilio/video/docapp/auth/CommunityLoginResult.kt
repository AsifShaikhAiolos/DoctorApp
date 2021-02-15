package com.twilio.video.docapp.auth

import com.twilio.video.docapp.data.api.AuthServiceError

sealed class CommunityLoginResult : LoginResult {
    data class CommunityLoginFailureResult(val error: AuthServiceError? = null) : CommunityLoginResult()
    object CommunityLoginSuccessResult : CommunityLoginResult()
}
