package com.twilio.video.docapp.ui

import com.twilio.video.docapp.base.BaseActivity
import com.twilio.video.docapp.ui.login.CommunityLoginActivity

class CommunityScreenSelector : ScreenSelector {

    override val loginScreen: Class<out BaseActivity>
        get() = CommunityLoginActivity::class.java
}
