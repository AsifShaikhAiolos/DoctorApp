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

package com.twilio.video.docapp;

import com.twilio.video.docapp.auth.AuthModule;
import com.twilio.video.docapp.data.DataModule;
import com.twilio.video.docapp.data.api.VideoAppServiceModule;
import com.twilio.video.docapp.sdk.VideoSdkModule;
import com.twilio.video.docapp.ui.ScreenSelectorModule;
import com.twilio.video.docapp.ui.login.LoginActivityModule;
import com.twilio.video.docapp.ui.room.RoomActivityModule;
import com.twilio.video.docapp.ui.room.VideoServiceModule;
import com.twilio.video.docapp.ui.settings.SettingsActivityModule;
import com.twilio.video.docapp.ui.settings.SettingsFragmentModule;
import com.twilio.video.docapp.ui.splash.SplashActivityModule;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@ApplicationScope
@Component(
        modules = {
            AndroidInjectionModule.class,
            ApplicationModule.class,
            TreeModule.class,
            DataModule.class,
            VideoAppServiceModule.class,
            ScreenSelectorModule.class,
            AuthModule.class,
            SplashActivityModule.class,
            LoginActivityModule.class,
            RoomActivityModule.class,
            SettingsActivityModule.class,
            SettingsFragmentModule.class,
            VideoServiceModule.class,
            VideoSdkModule.class,
            AudioSwitchModule.class
        })
public interface VideoApplicationComponent {
    void inject(VideoApplication application);
}
