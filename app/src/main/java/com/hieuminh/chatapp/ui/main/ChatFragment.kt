package com.hieuminh.chatapp.ui.main

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.hieuminh.chatapp.R
import com.hieuminh.chatapp.model.WordModel
import com.hieuminh.chatapp.presenter.ChatPresenter
import com.hieuminh.chatapp.presenter.Impl.ChatPresenterImpl
import com.hieuminh.chatapp.repository.WordRepository
import com.hieuminh.chatapp.ui.adapter.WordAdapter
import kotlinx.android.synthetic.main.fragment_chat.*

class ChatFragment : Fragment(), ChatPresenter.View {

    private lateinit var chatPresenter: ChatPresenter
    private lateinit var adapter : WordAdapter
    private lateinit var wordRepository : WordRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chat, container, false)
    }

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        chatPresenter = ChatPresenterImpl(context!!, this)
        chatPresenter.init()
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