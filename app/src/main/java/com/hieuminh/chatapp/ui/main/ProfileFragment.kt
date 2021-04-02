package com.hieuminh.chatapp.ui.main

import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import androidx.annotation.RequiresApi
import com.hieuminh.chatapp.R
import com.hieuminh.chatapp.utils.SessionUtil
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    private lateinit var sessionUtil: SessionUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sessionUtil = SessionUtil(context)
        sw_transfer_dark_mode.isChecked = sessionUtil.stateDarkModeState
        sw_floating_notice.isChecked = sessionUtil.displayNotice

        sw_transfer_dark_mode.setOnCheckedChangeListener { buttonView, isChecked ->
            if(sessionUtil.stateDarkModeState != isChecked) sessionUtil.stateDarkModeState = isChecked
        }

        sw_floating_notice.setOnCheckedChangeListener { buttonView, isChecked ->
            if(sessionUtil.displayNotice != isChecked) sessionUtil.displayNotice = isChecked
        }
    }
}