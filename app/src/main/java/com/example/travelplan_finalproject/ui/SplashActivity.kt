package com.example.travelplan_finalproject.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.travelplan_finalproject.BaseActivity
import com.example.travelplan_finalproject.R
import com.example.travelplan_finalproject.ui.main.LoginActivity

class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {
       val myHandler =Handler(Looper.getMainLooper())

        myHandler.postDelayed({
            val myIntent = Intent(mContext,LoginActivity::class.java)
            startActivity(myIntent)
        },2500)
    }
}