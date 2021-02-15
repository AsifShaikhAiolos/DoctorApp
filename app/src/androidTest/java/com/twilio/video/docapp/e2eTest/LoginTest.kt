package com.twilio.video.docapp.e2eTest

import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.GrantPermissionRule
import com.twilio.video.docapp.R
import com.twilio.video.docapp.screen.assertGoogleSignInButtonIsVisible
import com.twilio.video.docapp.screen.assertSignInErrorIsVisible
import com.twilio.video.docapp.screen.clickSettingsMenuItem
import com.twilio.video.docapp.screen.loginWithEmail
import com.twilio.video.docapp.screen.loginWithWrongEmailCreds
import com.twilio.video.docapp.ui.splash.SplashActivity
import com.twilio.video.docapp.util.getString
import com.twilio.video.docapp.util.retrieveEmailCredentials
import com.twilio.video.docapp.util.retryEspressoAction
import com.twilio.video.docapp.util.scrollAndClickView
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
@E2ETest
class LoginTest {

    @get:Rule
    var permissionRule = GrantPermissionRule.grant(android.Manifest.permission.CAMERA,
            android.Manifest.permission.RECORD_AUDIO)

    @get:Rule
    var scenario = activityScenarioRule<SplashActivity>()

    @Test
    fun `it_should_login_successfully_with_email_and_then_logout`() {
        val emailCredentials = retrieveEmailCredentials()
        loginWithEmail(emailCredentials)
        retryEspressoAction { clickSettingsMenuItem() }
        scrollAndClickView(getString(R.string.settings_screen_logout), R.id.recycler_view)

        retryEspressoAction { assertGoogleSignInButtonIsVisible() }
    }

    @Test
    fun `it_should_not_login_successfully_with_email`() {
        val emailCredentials = retrieveEmailCredentials()
        loginWithWrongEmailCreds(emailCredentials)
        retryEspressoAction { assertSignInErrorIsVisible() }
    }
}
