package com.example.travelplan_finalproject.dialog

import android.app.Activity
import android.app.Dialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import com.example.travelplan_finalproject.R
import com.example.travelplan_finalproject.databinding.ActivityCustomAlertDialogBinding

class CustomAlertDialog (val mContext : Context, val activity : Activity){

    val dialog = Dialog(mContext)
    lateinit var binding : ActivityCustomAlertDialogBinding

    fun myDialog () {
        binding = ActivityCustomAlertDialogBinding.inflate(activity.layoutInflater)
        dialog.setContentView(binding.root)

        dialog.window?.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)

        dialog.setCancelable(true)

        dialog.show()
    }
}