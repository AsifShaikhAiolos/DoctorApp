package com.twilio.video.docapp.e2eTest

import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiSelector
import androidx.test.uiautomator.Until
import com.twilio.video.docapp.R
import com.twilio.video.docapp.screen.assertRoomIsConnected
import com.twilio.video.docapp.screen.clickDisconnectButton
import com.twilio.video.docapp.screen.clickJoinRoomButton
import com.twilio.video.docapp.screen.enterRoomName
import com.twilio.video.docapp.ui.splash.SplashActivity
import com.twilio.video.docapp.util.getString
import com.twilio.video.docapp.util.randomUUID
import com.twilio.video.docapp.util.retryEspressoAction
import com.twilio.video.docapp.util.uiDevice
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
@E2ETest
class BackgroundSupportTest : BaseE2ETest() {

    @get:Rule
    var scenario = activityScenarioRule<SplashActivity>()

    @Test
    fun it_should_show_a_notification_when_the_app_is_in_the_background() {
        enterRoomName(randomUUID())
        clickJoinRoomButton()

        retryEspressoAction { assertRoomIsConnected() }

        uiDevice().run {
            pressHome()

            openNotification()

            // Click notification
            wait(Until.hasObject(By.pkg("com.android.systemui")), 10000)
            val notificationStackScroller = UiSelector()
                    .resourceId("com.android.systemui:id/notification_stack_scroller")
            findObject(notificationStackScroller)
                    .getChild(UiSelector().textContains(
                    getString(R.string.room_notification_message)))
                    .click()
        }

        retryEspressoAction { assertRoomIsConnected() }

        clickDisconnectButton()
    }
}
