package com.twilio.video.docapp.auth

import com.google.firebase.auth.FirebaseAuth

class FirebaseWrapper {

    val instance: FirebaseAuth
        get() = FirebaseAuth.getInstance()
}
