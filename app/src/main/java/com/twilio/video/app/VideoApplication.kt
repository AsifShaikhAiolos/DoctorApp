/*
 * Copyright (C) 2019 Twilio, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.twilio.video.app

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.facebook.stetho.Stetho
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import timber.log.Timber
import tvi.webrtc.voiceengine.WebRtcAudioManager.setBlacklistDeviceForOpenSLESUsage
import tvi.webrtc.voiceengine.WebRtcAudioUtils.deviceIsBlacklistedForOpenSLESUsage
import java.lang.ref.WeakReference
import javax.inject.Inject

class VideoApplication : Application(), HasAndroidInjector {



    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>
    @Inject
    lateinit var tree: Timber.Tree

    companion object {
        var mInstance =
                WeakReference<VideoApplication?>(null)
        val context: Context
            get() = mInstance.get()!!.applicationContext

        fun getInstance(): VideoApplication {
            return mInstance.get()!!;
        }
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        mInstance.clear()
        mInstance = WeakReference(this)
        if (!deviceIsBlacklistedForOpenSLESUsage()) {
            setBlacklistDeviceForOpenSLESUsage(true)
        }

        if(BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this);
        }

        DaggerVideoApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .build()
                .inject(this)

        Timber.plant(tree)

        startAppcenter(this)
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }
}
