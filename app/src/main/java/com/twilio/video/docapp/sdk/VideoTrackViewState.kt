package com.twilio.video.docapp.sdk

import com.twilio.video.VideoTrack

data class VideoTrackViewState constructor (
    val videoTrack: VideoTrack,
    val isSwitchedOff: Boolean = false
)
