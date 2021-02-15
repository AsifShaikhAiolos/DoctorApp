package com.twilio.video.docapp.security

import android.app.Application
import android.content.SharedPreferences
import com.twilio.video.docapp.ApplicationModule
import com.twilio.video.docapp.ApplicationScope
import com.twilio.video.docapp.data.DataModule
import dagger.Module
import dagger.Provides

@Module(includes = [
    ApplicationModule::class,
    DataModule::class
])
class SecurityModule {

    @Provides
    @ApplicationScope
    fun providesSecurePreferences(app: Application, preferences: SharedPreferences): SecurePreferences {
        return SecurePreferencesImpl(app.applicationContext, preferences)
    }
}
