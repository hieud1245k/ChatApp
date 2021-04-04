package com.hieuminh.chatapp.presenter

import android.content.Context
import com.hieuminh.chatapp.model.WordModel

interface ChatPresenter {

    fun init()

    interface View {
        fun initAdapter(context: Context, words : MutableList<WordModel>)
        fun initRecyclerView()
    }
}