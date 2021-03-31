package com.hieuminh.chatapp.presenter

import android.content.Context
import com.hieuminh.chatapp.model.UserModel

interface MainPresenter {

    fun init()

    interface View {
        fun initAdapter(context: Context, users: List<UserModel>)
        fun initRecyclerView()
    }
}
