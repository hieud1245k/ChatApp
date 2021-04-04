package com.hieuminh.chatapp.model

import java.time.LocalDate

class UserProfileModel() {

    private lateinit var fullName: String
    private lateinit var dateOfBirthDay: LocalDate
    private lateinit var phoneNumber: String
    private var status: Boolean = true
    private lateinit var avatar: String
}
