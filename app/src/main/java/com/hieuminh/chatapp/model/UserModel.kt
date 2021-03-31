package com.hieuminh.chatapp.model

import java.time.LocalDate

class UserModel() {

    private lateinit var id: String
    private lateinit var email: String
    private lateinit var password: String
    private lateinit var fullName: String
    private lateinit var dateOfBirthDay: LocalDate
    private lateinit var phoneNumber: String
    private var status: Boolean = true
    private lateinit var avatar: String
}
