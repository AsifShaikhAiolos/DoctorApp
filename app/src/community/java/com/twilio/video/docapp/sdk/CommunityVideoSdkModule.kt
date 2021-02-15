package com.twilio.video.docapp.sdk

import android.app.Application
import android.content.SharedPreferences
import com.twilio.video.docapp.ApplicationModule
import com.twilio.video.docapp.ApplicationScope
import com.twilio.video.docapp.data.AuthServiceModule
import com.twilio.video.docapp.data.DataModule
import com.twilio.video.docapp.data.api.TokenService
import dagger.Module
import dagger.Provides

@Module(includes = [
    ApplicationModule::class,
    DataModule::class,
    AuthServiceModule::class])
class CommunityVideoSdkModule {

    @Provides
    fun providesConnectOptionsFactory(
        application: Application,
        sharedPreferences: SharedPreferences,
        tokenService: TokenService
    ): ConnectOptionsFactory =
            ConnectOptionsFactory(application, sharedPreferences, tokenService)

    @Provides
    fun providesRoomFactory(
        application: Application,
        connectOptionsFactory: ConnectOptionsFactory
    ): VideoClient =
            VideoClient(application, connectOptionsFactory)

    @Provides
    @ApplicationScope
    fun providesRoomManager(
        application: Application,
        videoClient: VideoClient,
        sharedPreferences: SharedPreferences
    ): RoomManager =
            RoomManager(application, videoClient, sharedPreferences)
}
