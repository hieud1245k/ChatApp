package com.hieuminh.chatapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.hieuminh.chatapp.R
import com.hieuminh.chatapp.model.MessageModel
import com.hieuminh.chatapp.ui.main.MainFragment
import com.hieuminh.chatapp.ui.main.MainFragmentDirections
import de.hdodenhof.circleimageview.CircleImageView

class MessageAdapter(private val messages : MutableList<MessageModel>, private val context: Context) : RecyclerView.Adapter<MessageAdapter.MessageHolder>() {

    class MessageHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        public var avatar = itemView.findViewById<CircleImageView>(R.id.civ_avatar_item)
        public var fullName = itemView.findViewById<TextView>(R.id.tv_full_name_item)
        public var latestTextChat = itemView.findViewById<TextView>(R.id.tv_latest_text_chat_item)
        public var latestTimeChat = itemView.findViewById<TextView>(R.id.tv_latest_time_chat_item)
        public var container = itemView.findViewById<LinearLayout>(R.id.ll_container_message_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageHolder {
        return MessageHolder(LayoutInflater.from(context).inflate(R.layout.fragment_message_item,parent,false))
    }

    override fun onBindViewHolder(holder: MessageHolder, position: Int) {
        var msg = messages[position]
        holder.container.setOnClickListener {
            var action = MainFragmentDirections.actionMainFragmentToChatFragment("123")
            Navigation.findNavController(holder.itemView).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return messages.size
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }
}