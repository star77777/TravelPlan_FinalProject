package com.example.travelplan_finalproject.models

import com.google.gson.annotations.SerializedName
import java.util.*

class CalendarListData (
    val id : Int,
    val title : String,
    val datetime : Date,
    @SerializedName("start_place")
    val startPlace : String,
    @SerializedName("start_latitude")
    val startLatitude : Double,
    @SerializedName("start_longitude")
    val startLongitude : Double,
    val place : String,
    val latitude : Double,
    val longitude : Double,
    val user : UserData,
        ){
}