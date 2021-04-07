package com.hieuminh.chatapp.repository.Impl

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.hieuminh.chatapp.constant.Constant
import com.hieuminh.chatapp.database.sqlite.DatabaseWord
import com.hieuminh.chatapp.model.WordModel
import com.hieuminh.chatapp.repository.WordRepository
import java.time.LocalDate

class WordRepositoryImpl(private var context: Context) : WordRepository {

    private var dbWord : DatabaseWord = DatabaseWord(context)

    private val SQL = "SELECT * FROM words"

    @RequiresApi(Build.VERSION_CODES.O)
    override fun getAll(): MutableList<WordModel> {
        var list : MutableList<WordModel> = ArrayList()

        var words =  dbWord.open().getAll(SQL, null)
        words.reverse()
        list.addAll(words)
        list.add(WordModel(LocalDate.now(), "\uD83D\uDE02\uD83E\uDD23\uD83D\uDE22\uD83D\uDC6D\uD83E\uDD23\uD83D\uDE2C\uD83D\uDC6D\uD83E\uDD23\uD83C\uDF2C", Constant.RECEIVE_TYPE))
        list.add(WordModel(LocalDate.now(), "\uD83D\uDE34", Constant.SEND_TYPE))
        list.add(WordModel(LocalDate.now(), "Message", Constant.RECEIVE_TYPE))
        list.add(WordModel(LocalDate.now(), "Messsssssssssssssssss", Constant.RECEIVE_TYPE))
        dbWord.close()
        return list
    }
}