package com.example.travelplan_finalproject.adapters

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.travelplan_finalproject.addlist.TodoListActivity
import com.example.travelplan_finalproject.databinding.ListItemTravelListBinding
import com.example.travelplan_finalproject.models.CalendarListData
import java.text.SimpleDateFormat

class CalendarListRecylerViewAdapter(
    val mContext: Context,
    val mList: List<CalendarListData>,
    val isInvited: Boolean,
    // val itemClick: (CalendarListData) -> Unit

) : RecyclerView.Adapter<CalendarListRecylerViewAdapter.ItemViewHolder>() {
    interface ItemClick { //인터페이스
        fun onClick(view: View, position: Int)
    }


    inner class ItemViewHolder(var binding: ListItemTravelListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CalendarListData) {

            // binding.titleTxt.text = item.title
            val sdf = SimpleDateFormat("M/d ")
            binding.titleTxt.text = "제목:${item.title}"
            binding.dateTxt.text = "${sdf.format(item.datetime)}"
            binding.placeTxt.text = "약속 장소 : ${item.place}"
        }

        init {
            this.binding = binding

            //item Click Listener
            binding.TodayEdt.setOnClickListener(View.OnClickListener {
                val pos = adapterPosition
                Log.d("click", pos.toString() + " : click!")

            })

            //item LongClick Listener
            binding.TodayEdt.setOnLongClickListener(View.OnLongClickListener {
                val pos = adapterPosition
                Log.d("click", pos.toString() + " : Long click!")
                return@OnLongClickListener true
            })



        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            ListItemTravelListBinding
                .inflate(LayoutInflater.from(mContext), parent, false)

        )

    }


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(mList[position])
//        if (itemClick != null){
//            holder?.binding.TodayEdt.setOnClickListener(View.OnClickListener {
//                itemClick?.onClick(it, position)
//
//            })
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView?.context, TodoListActivity::class.java)
            ContextCompat.startActivity(holder.itemView.context, intent, null)
        }

//        holder.itemView.setOnLongClickListener {


       // }

    }
    override fun getItemCount(): Int {
        return mList.size
    }
}







