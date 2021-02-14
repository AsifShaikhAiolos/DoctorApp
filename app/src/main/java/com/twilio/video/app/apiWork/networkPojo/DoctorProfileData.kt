package com.twilio.video.app.apiWork.networkPojo

data class DoctorProfileData(
        val __v: Int,
        val _id: String,
        val address: String,
        val city: String,
        val createdAt: String,
        val duration: Int,
        val email: String,
        val gender: Int,
        val name: DoctorProfileName,
        val number_of_slots: Int,
        val phone_number: String,
        val pin_code: String,
        val prefix: String,
        val start_time: String,
        val state: String,
        val updatedAt: String,
        val user_id: String
)