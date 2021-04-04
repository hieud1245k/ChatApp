package com.hieuminh.chatapp.model

class AccountModel {

    private lateinit var id: String
    private lateinit var email: String
    private lateinit var password: String

    private lateinit var userProfile : UserProfileModel
    private lateinit var messages : MutableList<MessageModel>
}