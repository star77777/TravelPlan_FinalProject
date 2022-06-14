package com.example.travelplan_finalproject.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.travelplan_finalproject.api.APIList
import com.example.travelplan_finalproject.api.ServerApi
import com.example.travelplan_finalproject.naver.ApIListNaver
import com.example.travelplan_finalproject.naver.NaverServerApi
import retrofit2.Retrofit

abstract class BaseFragment:Fragment(){

    lateinit var mContext : Context

    lateinit var retrofit: Retrofit
    lateinit var apiList : APIList


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mContext = requireContext()
        retrofit = ServerApi.getRetrofit(mContext)

        apiList = retrofit.create(APIList::class.java)

    }

    abstract fun setupEvents()
    abstract fun setValues()
}