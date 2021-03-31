package com.hieuminh.chatapp.presenter

import com.hieuminh.chatapp.model.UserModel

interface RegisterPresenter {
    
    fun onRegister(userModel: UserModel)
    interface View {
        fun onRegisterPending()
        fun onRegisterSuccess()
        fun onRegisterFail()
        fun onStartProgressBar()
        fun onStopProgressBar()
    }
}