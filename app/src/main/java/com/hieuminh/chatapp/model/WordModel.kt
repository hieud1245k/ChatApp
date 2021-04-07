package com.hieuminh.chatapp.model

import java.time.LocalDate

class WordModel(internal var id : Int,internal var time: LocalDate, internal var text: String, internal var type: Int) {

    constructor(time: LocalDate, text: String, type: Int) : this(0, time, text, type) {
    }

    private var isDelete:Boolean = false
        set(value)  {field = value}
        get() = field
}