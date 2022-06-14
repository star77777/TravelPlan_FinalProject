package com.example.travelplan_finalproject

import android.content.Context
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.travelplan_finalproject.addlist.EditCalendarListActivity
import com.example.travelplan_finalproject.api.APIList
import com.example.travelplan_finalproject.api.ServerApi
import com.example.travelplan_finalproject.naver.ApIListNaver
import com.example.travelplan_finalproject.naver.NaverServerApi
import retrofit2.Retrofit

abstract class BaseActivity : AppCompatActivity() {


    lateinit var mContext: Context

    //  lateinit var titleTxt : TextView
    lateinit var retrofit: Retrofit
    lateinit var retrofit2: Retrofit
    lateinit var apiList: APIList
    lateinit var apiListNaver: ApIListNaver
    lateinit var addBtn: ImageView
    // mSelectedDateTime = Calendar.getInstance ()  // Calendar () 생성자 사용 X
    //val mSelectedDateTime2 = Calendar.getInstance ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = this

        retrofit = ServerApi.getRetrofit(mContext)
        retrofit2 = NaverServerApi.getRetrofit(mContext)
        apiList = retrofit.create(APIList::class.java)
        apiListNaver = retrofit2.create(ApIListNaver::class.java)
    }

    abstract fun setupEvents()

    abstract fun setValues()

}