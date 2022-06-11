package com.example.travelplan_finalproject.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.travelplan_finalproject.R
import com.example.travelplan_finalproject.api.APIList
import com.example.travelplan_finalproject.api.ServerApi

import com.example.travelplan_finalproject.databinding.ListItemTravelListBinding
import com.example.travelplan_finalproject.models.CalendarListData
import java.text.SimpleDateFormat

class CalendarListRecylerViewAdapter(
    val mContext: Context,
    val mList: List<CalendarListData>,
    isInvited: Boolean,


    ) : RecyclerView.Adapter<CalendarListRecylerViewAdapter.ItemViewHolder>() {
   inner class ItemViewHolder (val binding : ListItemTravelListBinding) : RecyclerView.ViewHolder(binding.root) {
       fun bind(item :CalendarListData) {
           val sdf = SimpleDateFormat("M/d a h:mm")
           binding.titleTxt.text = item.title

           binding.dateTxt.text = "${sdf.format(item.datetime)}"
           binding.placeTxt.text = "약속 장소 : ${item.place}"
       }

   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            ListItemTravelListBinding
                .inflate(LayoutInflater.from(mContext), parent, false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(mList[position])
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}