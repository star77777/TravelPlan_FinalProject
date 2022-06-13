package com.example.travelplan_finalproject.fragments

import android.app.TaskStackBuilder.create
import android.content.Context
import android.content.IntentFilter.create
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.travelplan_finalproject.api.APIList
import com.example.travelplan_finalproject.api.ServerApi
import com.example.travelplan_finalproject.naver.ApIListNaver
import com.example.travelplan_finalproject.naver.NaverApiData
import com.example.travelplan_finalproject.naver.NaverServerApi
import retrofit2.Retrofit
import java.net.URI.create

abstract class BaseFragment:Fragment(){

    lateinit var mContext : Context
    lateinit var retrofit2: Retrofit
    lateinit var retrofit: Retrofit
    lateinit var apiList : APIList
    lateinit var apiListNaver : ApIListNaver

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mContext = requireContext()
        retrofit = ServerApi.getRetrofit(mContext)
        retrofit2 = NaverServerApi.getRetrofit(mContext)
        apiList = retrofit.create(APIList::class.java)
        apiListNaver=retrofit2.create(ApIListNaver::class.java)
    }

    abstract fun setupEvents()
    abstract fun setValues()
}