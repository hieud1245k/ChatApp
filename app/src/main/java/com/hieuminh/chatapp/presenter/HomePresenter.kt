package com.hieuminh.chatapp.presenter

import android.content.Context
import com.hieuminh.chatapp.model.MessageModel
import com.hieuminh.chatapp.model.UserModel

interface HomePresenter {

    fun init()

    interface View {
        fun initAdapter(context: Context, messages: MutableList<MessageModel>)
        fun initRecyclerView()
    }
}
