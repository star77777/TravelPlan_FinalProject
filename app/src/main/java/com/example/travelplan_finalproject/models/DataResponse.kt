package com.example.travelplan_finalproject.models



class DataResponse (
    val user : UserData,
    val token : String,
    val code : Int,
    val message : String,
    val data : DataResponse,
    val users : List<UserData>,
    val calendarlist : CalendarListData,
    val calendarlists : List<CalendarListData>,
) {
}