package com.hieuminh.chatapp.repository.Impl

import android.content.Context
import com.hieuminh.chatapp.model.MessageModel
import com.hieuminh.chatapp.repository.MessageRepository

class MessageRepositoryImpl(private var context: Context) : MessageRepository {
    override fun getMessages(): MutableList<MessageModel> {
        var list:MutableList<MessageModel> = ArrayList()
        list.add(MessageModel())
        list.add(MessageModel())
        list.add(MessageModel())
        list.add(MessageModel())
        list.add(MessageModel())
        return list
    }
}