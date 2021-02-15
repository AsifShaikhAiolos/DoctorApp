package com.twilio.video.docapp.e2eTest

import com.twilio.video.docapp.screen.loginWithEmail
import com.twilio.video.docapp.util.allowAllPermissions
import com.twilio.video.docapp.util.retrieveEmailCredentials
import com.twilio.video.docapp.util.uiDevice
import org.junit.Before

@E2ETest
open class BaseE2ETest {
    @Before
    open fun setUp() {
        loginWithEmail(retrieveEmailCredentials())
        uiDevice().run {
            allowAllPermissions()
        }
    }
}
