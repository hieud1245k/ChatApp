package com.hieuminh.chatapp.presenter.Impl

import android.content.Context
import com.hieuminh.chatapp.database.sqlite.DatabaseWord
import com.hieuminh.chatapp.model.WordModel
import com.hieuminh.chatapp.presenter.ChatPresenter
import com.hieuminh.chatapp.repository.Impl.WordRepositoryImpl
import com.hieuminh.chatapp.repository.WordRepository
import com.hieuminh.chatapp.ui.adapter.WordAdapter

class ChatPresenterImpl(private var context: Context, private var view: ChatPresenter.View) : ChatPresenter {

    private lateinit var wordRepository: WordRepository
    private lateinit var dbWord : DatabaseWord

    init {
        wordRepository = WordRepositoryImpl(context)
        dbWord = DatabaseWord(context)
    }

    override fun init() {
        view.initAdapter(context,wordRepository.getAll())
        view.initRecyclerView()
    }

    override fun storeWordInSQLite(word: WordModel) {
        dbWord.open().createInsert(word)
        dbWord.close()
    }
}