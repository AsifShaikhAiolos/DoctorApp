package com.twilio.video.docapp.ui.room

import android.net.Uri

class UriWrapper(uri: Uri?) {

    val pathSegments: MutableList<String>? = uri?.pathSegments
}
