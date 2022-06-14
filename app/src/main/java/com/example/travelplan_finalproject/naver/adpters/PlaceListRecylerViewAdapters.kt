package com.example.travelplan_finalproject.naver.adpters

import android.content.Context
import android.content.Intent
import android.os.Build
import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.travelplan_finalproject.databinding.ListItemPlaceBinding
import com.example.travelplan_finalproject.naver.data.NaverApiData
import com.example.travelplan_finalproject.naver.add.MapActivity

class PlaceListRecylerViewAdapters (
    val mContext : Context,
    val mList : List<NaverApiData>
) : RecyclerView.Adapter<PlaceListRecylerViewAdapters.ItemViewHolder>() {

    inner class ItemViewHolder(val binding : ListItemPlaceBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind (item : NaverApiData) {

            binding.titleTxt.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                Html.fromHtml(item.title, Html.FROM_HTML_MODE_LEGACY).toString()
            } else {
                Html.fromHtml(item.title).toString()    }

            binding.addressTxt.text = item.roadAddress

            binding.showMapBtn.setOnClickListener {
                val myIntent = Intent(mContext, MapActivity::class.java)
                myIntent.putExtra("NaverApiData", item)
                mContext.startActivity(myIntent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(ListItemPlaceBinding.inflate(LayoutInflater.from(mContext), parent, false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(mList[position])
    }

    override fun getItemCount(): Int {
        return mList.size
    }

}