package com.twilio.video.docapp.ui.settings;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent
public interface SettingsFragmentSubcomponent extends AndroidInjector<SettingsFragment> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<SettingsFragment> {}
}
