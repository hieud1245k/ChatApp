package com.hieuminh.chatapp.presenter.Impl

import android.content.Context
import android.view.View
import com.hieuminh.chatapp.presenter.HomePresenter
import com.hieuminh.chatapp.repository.Impl.MessageRepositoryImpl
import com.hieuminh.chatapp.repository.MessageRepository

class HomePresenterImpl(private var context: Context, private var view: HomePresenter.View) : HomePresenter {

    private lateinit var messageRepository: MessageRepository

    init {
        this.messageRepository = MessageRepositoryImpl(context)
    }

    override fun init() {
        view.initAdapter(context,messageRepository.getMessages())
        view.initRecyclerView()
    }
}
