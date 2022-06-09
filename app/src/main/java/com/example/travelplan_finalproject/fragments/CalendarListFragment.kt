package com.example.travelplan_finalproject.fragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.travelplan_finalproject.R
import com.example.travelplan_finalproject.adapters.CalendarListRecylerViewAdapter
import com.example.travelplan_finalproject.addlist.EditCalendarListActivity
import com.example.travelplan_finalproject.databinding.ActivityCalendarListFragmentBinding
import com.example.travelplan_finalproject.models.CalendarListData

class CalendarListFragment : BaseFragment() {

    lateinit var binding : ActivityCalendarListFragmentBinding
lateinit var mCalendarAdapter:CalendarListRecylerViewAdapter
    var mCalendarList = ArrayList<CalendarListData>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.activity_calendar_list_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        binding.addTodayBtn.setOnClickListener {
            val myIntent = Intent(mContext, EditCalendarListActivity::class.java)
            startActivity(myIntent)
        }
    }
    override fun onResume() {
        super.onResume()

    }

    override fun setValues() {
        mCalendarAdapter = CalendarListRecylerViewAdapter(mContext, mCalendarList)
        binding.calendarListsRecyclerView.adapter =mCalendarAdapter
        binding.calendarListsRecyclerView.layoutManager = LinearLayoutManager(mContext)
    }


}