package com.twilio.video.docapp.screen

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.twilio.video.docapp.R

fun clickGoogleSignInButton() {
    onView(withId(R.id.google_sign_in)).perform(click())
}
