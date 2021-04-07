package com.hieuminh.chatapp.ui.main

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.hieuminh.chatapp.R
import com.hieuminh.chatapp.constant.Constant
import com.hieuminh.chatapp.database.sqlite.DatabaseWord
import com.hieuminh.chatapp.model.WordModel
import com.hieuminh.chatapp.presenter.ChatPresenter
import com.hieuminh.chatapp.presenter.Impl.ChatPresenterImpl
import com.hieuminh.chatapp.repository.WordRepository
import com.hieuminh.chatapp.ui.adapter.WordAdapter
import kotlinx.android.synthetic.main.fragment_chat.*
import kotlinx.android.synthetic.main.fragment_chat.view.*
import java.time.LocalDate

class ChatFragment : Fragment(), ChatPresenter.View {

    private lateinit var chatPresenter: ChatPresenter
    private lateinit var adapter : WordAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_chat, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("UseRequireInsteadOfGet")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        chatPresenter = ChatPresenterImpl(context!!, this)
        chatPresenter.init()

        iv_send_chat.setOnClickListener {
            var word = WordModel(LocalDate.now(), et_text_chat.text.toString() ,Constant.SEND_TYPE)
            Log.d("Mess", et_text_chat.text.toString())
            et_text_chat.setText("")
            chatPresenter.storeWordInSQLite(word)
            adapter.AddItem(word)
        }
    }

    override fun initAdapter(context: Context, words: MutableList<WordModel>) {
        adapter = WordAdapter(words, context)
    }

    override fun initRecyclerView() {
        val layoutManager = LinearLayoutManager(null)
        layoutManager.reverseLayout = true
        rv_chat.layoutManager = layoutManager
        rv_chat.adapter = adapter
    }
}