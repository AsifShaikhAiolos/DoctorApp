package com.twilio.video.docapp.auth

import com.google.firebase.auth.GoogleAuthProvider

class GoogleAuthProviderWrapper {

    fun getCredential(idToken: String) = GoogleAuthProvider.getCredential(idToken, null)
}
