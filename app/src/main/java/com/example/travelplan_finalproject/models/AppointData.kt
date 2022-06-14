package com.example.travelplan_finalproject.models

data class AppointData(
    val travelDatas:DataResponse,
    val title:String,
    val AppointLists : List<CalendarListData>,


) {
}