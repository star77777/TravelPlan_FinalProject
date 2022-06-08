package com.example.travelplan_finalproject.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.travelplan_finalproject.BaseActivity
import com.example.travelplan_finalproject.R
import com.example.travelplan_finalproject.databinding.ActivityMainBinding

class MainActivity  : BaseActivity() {

    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        binding.logoutBtn.setOnClickListener {
            val myIntent = Intent(mContext, LoginActivity::class.java)
            startActivity(myIntent)
            finish()
        }
    }

    override fun setValues() {

    }
}