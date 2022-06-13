package com.example.travelplan_finalproject.fragments


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.travelplan_finalproject.R
import com.example.travelplan_finalproject.adapters.TodoListRecyclerViewAdapers
import com.example.travelplan_finalproject.addlist.TodoListActivity
import com.example.travelplan_finalproject.databinding.ActivityTodoListFragmentsBinding
import com.example.travelplan_finalproject.models.BasicResponse
import com.example.travelplan_finalproject.models.CalendarListData
import com.example.travelplan_finalproject.models.TodoListDatas
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TodoListFragments : BaseFragment() {

    lateinit var binding: ActivityTodoListFragmentsBinding
    lateinit var mTodoListAdapter: TodoListRecyclerViewAdapers
    var mTodoList = ArrayList<CalendarListData>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.activity_todo_list_fragments,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        binding.addHourListBtn.setOnClickListener {
            val myIntent = Intent(mContext, TodoListActivity::class.java)
            startActivity(myIntent)
        }
    }

    override fun onResume() {
        super.onResume()
        getMyAppointmentListFromServer()
    }

    override fun setValues() {
        mTodoListAdapter = TodoListRecyclerViewAdapers(mContext, mTodoList, false)
        binding.hourListRecyclerView.adapter = mTodoListAdapter
        binding.hourListRecyclerView.layoutManager = LinearLayoutManager(mContext)
    }

    fun getMyAppointmentListFromServer() {
        apiList.getRequestMdataList().enqueue(object : Callback<BasicResponse> {
            override fun onResponse(call: Call<BasicResponse>, response: Response<BasicResponse>) {
                if (response.isSuccessful) {
                    val br = response.body()!!
                    mTodoList.clear()
                    mTodoList.addAll(br.data.calendarlists)

                    mTodoListAdapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<BasicResponse>, t: Throwable) {

            }
        })

    }
}