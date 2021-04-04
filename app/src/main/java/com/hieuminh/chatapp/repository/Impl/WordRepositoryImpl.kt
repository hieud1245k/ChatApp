package com.hieuminh.chatapp.repository.Impl

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.hieuminh.chatapp.constant.Constant
import com.hieuminh.chatapp.model.WordModel
import com.hieuminh.chatapp.repository.WordRepository
import java.time.LocalDate

class WordRepositoryImpl(private var context: Context) : WordRepository {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun getAll(): MutableList<WordModel> {
        var list : MutableList<WordModel> = ArrayList()
        list.add(WordModel(LocalDate.now(), "dfsdkjf", Constant.SEND_TYPE))
        list.add(WordModel(LocalDate.now(), "dfsdkjf", Constant.SEND_TYPE))
        list.add(WordModel(LocalDate.now(), "dfsdkjf", Constant.SEND_TYPE))
        list.add(WordModel(LocalDate.now(), "dfsdkjf", Constant.RECEIVE_TYPE))
        list.add(WordModel(LocalDate.now(), "dcvcxcvxcvcxvcbcv dcvdzcb dvzsc zdvzxcfsdkjf", Constant.SEND_TYPE))
        list.add(WordModel(LocalDate.now(), "dfsdkjf", Constant.RECEIVE_TYPE))
        list.add(WordModel(LocalDate.now(), "dfsdkjf", Constant.SEND_TYPE))
        list.add(WordModel(LocalDate.now(), "dfsdkjf", Constant.RECEIVE_TYPE))
        list.add(WordModel(LocalDate.now(), "dfsd dvzsdfserga dgasd sedfasdfkjf", Constant.RECEIVE_TYPE))
        list.add(WordModel(LocalDate.now(), "dfsdkjf", Constant.SEND_TYPE))
        list.add(WordModel(LocalDate.now(), "dfsdkjf", Constant.RECEIVE_TYPE))
        list.add(WordModel(LocalDate.now(), "dfsdkjf", Constant.RECEIVE_TYPE))
        list.add(WordModel(LocalDate.now(), "dfsdkjf", Constant.SEND_TYPE))
        list.add(WordModel(LocalDate.now(), "dfsdkjf", Constant.RECEIVE_TYPE))
        list.add(WordModel(LocalDate.now(), "dfsdkjf", Constant.RECEIVE_TYPE))
        list.add(WordModel(LocalDate.now(), "dfsdkjf", Constant.SEND_TYPE))
        list.add(WordModel(LocalDate.now(), "dfsdkjf", Constant.RECEIVE_TYPE))
        list.add(WordModel(LocalDate.now(), "dfsdkjf", Constant.RECEIVE_TYPE))
        list.add(WordModel(LocalDate.now(), "dfsdkjf", Constant.SEND_TYPE))
        list.add(WordModel(LocalDate.now(), "dfsdkjf", Constant.RECEIVE_TYPE))
        list.add(WordModel(LocalDate.now(), "dfsdkjf", Constant.RECEIVE_TYPE))
        return list
    }
}