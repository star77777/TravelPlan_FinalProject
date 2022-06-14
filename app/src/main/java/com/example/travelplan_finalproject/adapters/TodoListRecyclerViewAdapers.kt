package com.example.travelplan_finalproject.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.travelplan_finalproject.databinding.ListItemTodoListsBinding
import com.example.travelplan_finalproject.models.CalendarListData
import java.text.SimpleDateFormat

class TodoListRecyclerViewAdapers(
    val mContext: Context,
    val mList: List<CalendarListData>,
    val isInvited: Boolean
) : RecyclerView.Adapter<TodoListRecyclerViewAdapers.ItemHourViewHolder>() {
    inner class ItemHourViewHolder(val binding: ListItemTodoListsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CalendarListData) {
            binding.titleHourTxt.text = item.title

            val sdfs = SimpleDateFormat("M/d a h:mm")

            binding.timeHourTxt.text = "${sdfs.format(item.datetime)}"
            binding.placeHourNameTxt.text = "약속 장소 : ${item.place}"

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHourViewHolder {
        return ItemHourViewHolder(
            ListItemTodoListsBinding
                .inflate(LayoutInflater.from(mContext), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemHourViewHolder, position: Int) {
        holder.bind(mList[position])
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}