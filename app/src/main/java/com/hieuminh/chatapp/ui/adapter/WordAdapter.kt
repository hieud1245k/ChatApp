package com.hieuminh.chatapp.ui.adapter

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hieuminh.chatapp.R
import com.hieuminh.chatapp.constant.Constant
import com.hieuminh.chatapp.database.sqlite.DatabaseWord
import com.hieuminh.chatapp.model.WordModel
import kotlinx.android.synthetic.main.fragment_chat_receive.view.*
import kotlinx.android.synthetic.main.fragment_chat_send.view.*

class WordAdapter(private var words : MutableList<WordModel>, private var context: Context) : RecyclerView.Adapter<WordAdapter.WordHolder>() {

    class WordHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    public fun AddItem(word: WordModel) {
        words.add(0, word)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordHolder {
        when(viewType) {
            Constant.SEND_TYPE -> return WordAdapter.WordHolder(
                LayoutInflater.from(context).inflate(R.layout.fragment_chat_send, parent, false))
            Constant.RECEIVE_TYPE -> return WordAdapter.WordHolder(
                LayoutInflater.from(context).inflate(R.layout.fragment_chat_receive, parent, false))
            else -> {
                return WordAdapter.WordHolder(
                    LayoutInflater.from(context).inflate(R.layout.fragment_chat_send, parent, false))
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return words[position].type
    }

    override fun onBindViewHolder(holder: WordHolder, position: Int) {
        var word : WordModel = words[position]
        if(word.type == Constant.SEND_TYPE) {
            holder.itemView.tv_text_send_item.setText(word.text)
            holder.itemView.tv_time_send_item.setText(word.time.toString())

            holder.itemView.tv_text_send_item.setOnClickListener {

                AlertDialog.Builder(context)
                    .setTitle("Notice!")
                    .setMessage("Are you sure you wan to delete?")
                    .setNegativeButton("No", DialogInterface.OnClickListener { dialog, which ->
                        dialog.cancel()
                    })
                    .setNeutralButton("Yes", DialogInterface.OnClickListener { dialog, which -> var db = DatabaseWord(context)
                        db.open().deleteColumn(word.id)
                        db.close()
                        words.removeAt(position)
                        this.notifyDataSetChanged() })
                    .show()
            }
        } else {
            holder.itemView.tv_text_receive_item.setText(word.text)
            holder.itemView.tv_time_receive_item.setText(word.time.toString())
        }
    }

    override fun getItemCount(): Int {
        return words.size
    }
}