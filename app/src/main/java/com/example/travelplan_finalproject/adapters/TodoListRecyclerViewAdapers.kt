package com.example.travelplan_finalproject.adapters

import android.content.Context
import android.content.Intent
import android.os.Build
import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.travelplan_finalproject.databinding.ListItemPlaceBinding
import com.example.travelplan_finalproject.databinding.ListItemTodoListsBinding
import com.example.travelplan_finalproject.models.CalendarListData
import com.example.travelplan_finalproject.naver.add.MapActivity
import com.example.travelplan_finalproject.naver.data.NaverApiData
import java.text.SimpleDateFormat

class TodoListRecyclerViewAdapers(
    val mContext: Context,
    val mList: List<CalendarListData>

) : RecyclerView.Adapter<TodoListRecyclerViewAdapers.ItemHourViewHolder>() {
    inner class ItemHourViewHolder(val binding: ListItemTodoListsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CalendarListData) {
            binding.titleHourTxt.text = item.title

            val sdfs = SimpleDateFormat("h:mm")
           // binding.expenseTxt.text= "비용 : ${item.longitude}"
            binding.timeHourTxt.text = "${sdfs.format(item.datetime)}"
           binding.placeHourNameTxt.text = "약속 장소 :${item.place}"


        }
//        fun bind(item:NaverApiData){
//            binding.placeHourNameTxt.text = "약속 장소 : ${item.title}"
//        }
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