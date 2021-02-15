package com.twilio.video.docapp.ui.room

import com.twilio.video.Room
import com.twilio.video.docapp.data.api.AuthServiceError
import io.uniflow.core.flow.data.UIEvent

sealed class RoomViewEffect : UIEvent() {

    object PermissionsDenied : RoomViewEffect()
    data class Connected(val room: Room) : RoomViewEffect()
    object Disconnected : RoomViewEffect()

    object ShowConnectFailureDialog : RoomViewEffect()
    object ShowMaxParticipantFailureDialog : RoomViewEffect()
    data class ShowTokenErrorDialog(val serviceError: AuthServiceError? = null) : RoomViewEffect()
}
