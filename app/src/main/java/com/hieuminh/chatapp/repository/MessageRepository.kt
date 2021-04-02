package com.hieuminh.chatapp.repository

import com.hieuminh.chatapp.model.MessageModel

interface MessageRepository {

    fun getMessages() : MutableList<MessageModel>
}