package com.example.travelplan_finalproject.fragments


import android.annotation.SuppressLint
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TimePicker
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.travelplan_finalproject.BaseActivity
import com.example.travelplan_finalproject.R
import com.example.travelplan_finalproject.adapters.CalendarListRecylerViewAdapter
import com.example.travelplan_finalproject.adapters.TodoListRecyclerViewAdapers
import com.example.travelplan_finalproject.addlist.TodoListActivityfagxx
import com.example.travelplan_finalproject.databinding.ActivityEditTodoListBinding
import com.example.travelplan_finalproject.models.BasicResponse
import com.example.travelplan_finalproject.models.CalendarListData
import com.example.travelplan_finalproject.models.TodoListDatas
import com.example.travelplan_finalproject.naver.data.NaverApiData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import java.text.SimpleDateFormat
import java.util.*

class TodoListActivity : BaseActivity() {

    lateinit var binding: ActivityEditTodoListBinding

    lateinit var mTodoListAdapter: TodoListRecyclerViewAdapers
    var mTodoList = ArrayList<CalendarListData>()


    lateinit var travelData: CalendarListData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_edit_todo_list)
        travelData = intent.getSerializableExtra("travelData") as CalendarListData
        setupEvents()
        setValues()
    }


    @SuppressLint("ClickableViewAccessibility")
    override fun setupEvents() {
        binding.addHourListBtn.setOnClickListener {
            val myIntent = Intent(mContext, TodoListActivityfagxx::class.java)
            myIntent.putExtra("travelData", travelData)
            startActivity(myIntent)
        }


    }

    override fun onResume() {
        super.onResume()
        getMyAppointmentListFromServer()
    }


    override fun setValues() {


        mTodoListAdapter = TodoListRecyclerViewAdapers(mContext, mTodoList)
        binding.hourListRecyclerView.adapter = mTodoListAdapter
        binding.hourListRecyclerView.layoutManager = LinearLayoutManager(mContext)
    }

    //var lists= travelData.data.title
    fun getMyAppointmentListFromServer() {
        apiList.getRequestMdataList().enqueue(object : Callback<BasicResponse> {
            override fun onResponse(call: Call<BasicResponse>, response: Response<BasicResponse>) {
                if (response.isSuccessful) {
                    val br = response.body()!!
                    //mTodoList.clear()
                      mTodoList.clear()
                    val sdf = SimpleDateFormat("h:mm:ss")
                    for (data in br.data.calendarlists) {
////                        //  val time = sdf.format(data.datetime)
                        val title = data.title
////                        val hour = data.datetime
                        val title1 = travelData.title
////                        val hour1 = travelData.datetime
                        val time = sdf.format(data.datetime)
                      if (title == title1) {
                          if (time != "6:11:11") {
                              mTodoList.add(data)
                              Log.d("data", data.toString())
                              Log.d("list", mTodoList.size.toString())
                          }
                     }
                   }

                   // mTodoList.addAll(br.data.calendarlists)
                    mTodoListAdapter.notifyDataSetChanged()
                }


                }

            override fun onFailure(call: Call<BasicResponse>, t: Throwable) {

            }


        })

    }
}









