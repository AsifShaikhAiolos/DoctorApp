package com.twilio.video.docapp

import android.app.Application
import com.twilio.video.docapp.auth.AuthenticationProvider
import com.twilio.video.docapp.auth.Authenticator
import com.twilio.video.docapp.auth.EmailAuthProvider
import com.twilio.video.docapp.auth.FirebaseAuthenticator
import com.twilio.video.docapp.auth.FirebaseWrapper
import com.twilio.video.docapp.auth.GoogleAuthProvider
import com.twilio.video.docapp.auth.GoogleAuthProviderWrapper
import com.twilio.video.docapp.auth.GoogleAuthWrapper
import com.twilio.video.docapp.auth.GoogleSignInOptionsWrapper
import com.twilio.video.docapp.auth.GoogleSignInWrapper
import dagger.Module
import dagger.Provides

@Module(includes = [
    ApplicationModule::class,
    TestWrapperAuthModule::class
])
class TestAuthModule {

    @Provides
    @ApplicationScope
    internal fun providesAuthenticator(
        firebaseWrapper: FirebaseWrapper,
        googleAuthWrapper: GoogleAuthWrapper,
        googleSignInWrapper: GoogleSignInWrapper,
        googleSignInOptionsWrapper: GoogleSignInOptionsWrapper,
        googleAuthProviderWrapper: GoogleAuthProviderWrapper,
        application: Application
    ): Authenticator {
        val authenticators = ArrayList<AuthenticationProvider>()
        authenticators.add(
                GoogleAuthProvider(
                        firebaseWrapper,
                        application,
                        googleAuthWrapper,
                        googleSignInWrapper,
                        googleSignInOptionsWrapper,
                        googleAuthProviderWrapper)
        )
        authenticators.add(EmailAuthProvider(firebaseWrapper))
        return FirebaseAuthenticator(firebaseWrapper, authenticators)
    }
}
