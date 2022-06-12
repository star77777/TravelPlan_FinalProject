package com.example.travelplan_finalproject.models

import com.google.gson.annotations.SerializedName


data class DataResponse (
    val user : UserData,
    val token : String,
    val code : Int,
    val message : String,
    val data : DataResponse,
    val users : List<UserData>,
    @SerializedName("appointment")
    val calendarlist : CalendarListData,
    @SerializedName("appointments")
    val calendarlists : List<CalendarListData>,

//    @SerializedName("appointment")
//    val Todolist : CalendarListData,
//    @SerializedName("appointments")
//    val Todolists : List<CalendarListData>,
) {
}