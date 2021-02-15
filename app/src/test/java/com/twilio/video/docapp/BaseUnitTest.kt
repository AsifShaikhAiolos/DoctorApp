package com.twilio.video.docapp

import net.lachlanmckee.timberjunit.TimberTestRule
import org.junit.Rule

open class BaseUnitTest {
    @get:Rule
    var logAllAlwaysRule = TimberTestRule.logAllAlways()
}
