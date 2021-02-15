package com.twilio.video.docapp

import com.twilio.video.docapp.auth.CommunityAuthModule
import com.twilio.video.docapp.data.DataModule
import com.twilio.video.docapp.ui.login.CommunityLoginActivity
import com.twilio.video.docapp.ui.login.CommunityLoginActivityModule
import com.twilio.video.docapp.ui.login.LoginActivityModule
import dagger.Component
import dagger.android.AndroidInjectionModule

@ApplicationScope
@Component(modules = [
    AndroidInjectionModule::class,
    ApplicationModule::class,
    DataModule::class,
    CommunityAuthModule::class,
    LoginActivityModule::class,
    CommunityLoginActivityModule::class
])
interface CommunityIntegrationTestComponent {
    fun inject(testApp: TestApp)
    fun inject(loginActivity: CommunityLoginActivity)
}
