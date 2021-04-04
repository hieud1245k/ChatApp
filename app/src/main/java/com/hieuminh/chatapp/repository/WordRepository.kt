package com.hieuminh.chatapp.repository

import com.hieuminh.chatapp.model.WordModel

interface WordRepository {
    fun getAll() : MutableList<WordModel>
}