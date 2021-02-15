package com.twilio.video.docapp.ui

import com.twilio.video.docapp.base.BaseActivity

interface ScreenSelector {

    val loginScreen: Class<out BaseActivity>
}
