package com.twilio.video.docapp

import com.twilio.video.docapp.data.DataModule
import com.twilio.video.docapp.ui.login.LoginActivity
import com.twilio.video.docapp.ui.login.LoginActivityModule
import dagger.Component
import dagger.android.AndroidInjectionModule

@ApplicationScope
@Component(modules = [
    AndroidInjectionModule::class,
    ApplicationModule::class,
    DataModule::class,
    TestWrapperAuthModule::class,
    TestAuthModule::class,
    LoginActivityModule::class
])
interface IntegrationTestComponent {
    fun inject(testApp: TestApp)
    fun inject(loginActivity: LoginActivity)
}
