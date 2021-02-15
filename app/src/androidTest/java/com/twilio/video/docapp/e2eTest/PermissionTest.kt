package com.twilio.video.docapp.e2eTest

import androidx.test.ext.junit.rules.activityScenarioRule
import com.twilio.video.docapp.screen.assertMicButtonIsDisabled
import com.twilio.video.docapp.screen.assertMicButtonIsEnabled
import com.twilio.video.docapp.screen.assertParticipantStubIsHidden
import com.twilio.video.docapp.screen.assertVideoButtonIsDisabled
import com.twilio.video.docapp.screen.assertVideoButtonIsEnabled
import com.twilio.video.docapp.screen.loginWithEmail
import com.twilio.video.docapp.ui.splash.SplashActivity
import com.twilio.video.docapp.util.allowAllPermissions
import com.twilio.video.docapp.util.denyAllPermissions
import com.twilio.video.docapp.util.retrieveEmailCredentials
import com.twilio.video.docapp.util.retryEspressoAction
import com.twilio.video.docapp.util.uiDevice
import org.junit.Rule
import org.junit.Test

@E2ETest
class PermissionTest {

    @get:Rule
    var scenario = activityScenarioRule<SplashActivity>()

    @Test
    fun `it_should_render_the_local_video_track_before_connecting_to_a_room`() {
        loginWithEmail(retrieveEmailCredentials())

        uiDevice().run {
            allowAllPermissions()
        }

        retryEspressoAction { assertParticipantStubIsHidden() }
        assertVideoButtonIsEnabled()
        assertMicButtonIsEnabled()
    }

    @Test
    fun `it_should_display_disabled_mic_and_camera_buttons_when_permissions_are_denied`() {
        loginWithEmail(retrieveEmailCredentials())

        uiDevice().run {
            denyAllPermissions()
        }

        retryEspressoAction { assertVideoButtonIsDisabled() }
        assertMicButtonIsDisabled()
    }
}
