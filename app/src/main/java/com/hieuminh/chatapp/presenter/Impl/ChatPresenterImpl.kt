package com.hieuminh.chatapp.presenter.Impl

import android.content.Context
import com.hieuminh.chatapp.presenter.ChatPresenter
import com.hieuminh.chatapp.repository.Impl.WordRepositoryImpl
import com.hieuminh.chatapp.repository.WordRepository

class ChatPresenterImpl(private var context: Context, private var view: ChatPresenter.View) : ChatPresenter {

    private lateinit var wordRepository: WordRepository

    init {
        wordRepository = WordRepositoryImpl(context)
    }

    override fun init() {
        view.initAdapter(context,wordRepository.getAll())
        view.initRecyclerView()
    }
}