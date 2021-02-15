package com.twilio.video.docapp.ui;

import com.twilio.video.docapp.ApplicationScope;
import dagger.Module;
import dagger.Provides;

@Module
public class CommunityScreenSelectorModule {

    @Provides
    @ApplicationScope
    ScreenSelector providesScreenSelector() {
        return new CommunityScreenSelector();
    }
}
