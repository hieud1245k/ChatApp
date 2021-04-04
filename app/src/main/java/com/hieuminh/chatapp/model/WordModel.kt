package com.hieuminh.chatapp.model

import java.time.LocalDate

class WordModel(internal var time: LocalDate, internal var text: String, internal var type: Int) {

    private var isDelete:Boolean = false
        set(value)  {field = value}
        get() = field
}