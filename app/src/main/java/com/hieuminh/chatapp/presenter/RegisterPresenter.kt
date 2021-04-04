package com.hieuminh.chatapp.presenter

import com.hieuminh.chatapp.model.UserProfileModel

interface RegisterPresenter {
    
    fun onRegister(userModel: UserProfileModel)
    interface View {
        fun onRegisterPending()
        fun onRegisterSuccess()
        fun onRegisterFail()
        fun onStartProgressBar()
        fun onStopProgressBar()
    }
}