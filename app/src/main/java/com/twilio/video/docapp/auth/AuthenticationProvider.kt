package com.twilio.video.docapp.auth

import io.reactivex.Observable

interface AuthenticationProvider {

    fun login(loginEventObservable: Observable<LoginEvent>): Observable<LoginResult>

    fun logout()
}
