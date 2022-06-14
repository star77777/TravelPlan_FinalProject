package com.example.travelplan_finalproject.addlist


import android.annotation.SuppressLint
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.TimePicker
import androidx.databinding.DataBindingUtil
import com.example.travelplan_finalproject.BaseActivity
import com.example.travelplan_finalproject.R
import com.example.travelplan_finalproject.databinding.ActivityEditTodoListBinding
import com.example.travelplan_finalproject.databinding.ActivityEditTodoListsBinding
import com.example.travelplan_finalproject.naver.data.NaverApiData

import java.text.SimpleDateFormat
import java.util.*

class TodoListActivityfagxx : BaseActivity() {
    lateinit var binding: ActivityEditTodoListsBinding

    var mPlaceList = ArrayList<NaverApiData>()

    //    선택한 약속 일시를 저장할 멤버변수
    val mSelectedDateTime2 = Calendar.getInstance()!!// 기본값 : 현재시간
    var mSelectedLatitude = 37.5779235853308
    var mSelectedLongitude = 127.033553463647


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_edit_todo_lists)
        setupEvents()
        setValues()

    }


    override fun setupEvents() {
        //시간 선택
        binding.timeTxt.setOnClickListener {

            val tsl = object : TimePickerDialog.OnTimeSetListener {
                override fun onTimeSet(p0: TimePicker?, hour: Int, minute: Int) {
                    mSelectedDateTime2.set(Calendar.HOUR_OF_DAY, hour)
                    mSelectedDateTime2.set(Calendar.MINUTE, minute)

                    //   오후 12:10 형태로 가공
                    val sdf = SimpleDateFormat("a h:mm")
                    binding.timeTxt.text = sdf.format(mSelectedDateTime2.time)

                }
            }

            TimePickerDialog(
                mContext,
                tsl,
                mSelectedDateTime2.get(Calendar.HOUR_OF_DAY),
                mSelectedDateTime2.get(Calendar.MINUTE),
                false
            ).show()


        }


    }

    override fun setValues() {

    }
}



