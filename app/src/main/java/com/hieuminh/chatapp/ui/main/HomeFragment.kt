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
import com.hieuminh.chatapp.model.MessageModel
import com.hieuminh.chatapp.presenter.HomePresenter
import com.hieuminh.chatapp.presenter.Impl.HomePresenterImpl
import com.hieuminh.chatapp.repository.MessageRepository
import com.hieuminh.chatapp.ui.adapter.MessageAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), HomePresenter.View {

    private lateinit var adapter : MessageAdapter
    private lateinit var presenter : HomePresenter
    private lateinit var messageRepository: MessageRepository
    private var messages: MutableList<MessageModel> = ArrayList<MessageModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = HomePresenterImpl(context!!, this)
        presenter.init()

        rv_message_list
    }

    override fun initAdapter(context: Context, messages: MutableList<MessageModel>) {
        adapter = MessageAdapter(messages, context)
    }

    override fun initRecyclerView() {
        rv_message_list.layoutManager = LinearLayoutManager(null)
        rv_message_list.adapter = adapter
    }
}