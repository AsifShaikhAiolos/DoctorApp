package com.twilio.video.docapp.ui

import com.twilio.video.docapp.base.BaseActivity
import com.twilio.video.docapp.ui.login.LoginActivity

class ProductionScreenSelector : ScreenSelector {

    override val loginScreen: Class<out BaseActivity>
        get() = LoginActivity::class.java
}
