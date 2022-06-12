package com.example.travelplan_finalproject.addlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.travelplan_finalproject.BaseActivity
import com.example.travelplan_finalproject.R
import com.example.travelplan_finalproject.databinding.ActivityTodoListBinding

class TodoListActivity :  BaseActivity() {
    lateinit var binding : ActivityTodoListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_todo_list)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {


    }

    override fun setValues() {

    }
}