package com.hieuminh.chatapp.presenter

import android.content.Context
import com.hieuminh.chatapp.model.WordModel

interface ChatPresenter {

    fun init()

    fun storeWordInSQLite(word : WordModel)

    interface View {
        fun initAdapter(context: Context, words : MutableList<WordModel>)
        fun initRecyclerView()
    }
}