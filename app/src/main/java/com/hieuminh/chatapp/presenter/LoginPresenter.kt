package com.hieuminh.chatapp.presenter

interface LoginPresenter {

    fun onLogin(email: String, password: String)

    interface View {
        fun onLoginPending()
        fun onLoginSuccess()
        fun onLoginFail()
        fun onStartProgressBar()
        fun onStopProgressBar()
        fun requestLogin(email: String, password: String)
    }
}
