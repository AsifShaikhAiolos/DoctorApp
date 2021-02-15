package com.twilio.video.docapp.ui;

import com.twilio.video.docapp.ApplicationScope;
import dagger.Module;
import dagger.Provides;

@Module
public class ScreenSelectorModule {

    @Provides
    @ApplicationScope
    ScreenSelector providesScreenSelector() {
        return new ProductionScreenSelector();
    }
}
