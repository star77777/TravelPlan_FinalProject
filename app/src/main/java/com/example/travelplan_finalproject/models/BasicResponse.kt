package com.example.travelplan_finalproject.models

data class BasicResponse(
    val code : Int,
    val message : String,
    val data : DataResponse,
) {
}