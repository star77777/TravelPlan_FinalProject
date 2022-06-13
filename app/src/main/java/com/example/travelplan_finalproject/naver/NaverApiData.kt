package com.example.travelplan_finalproject.naver

import java.io.Serializable

data class NaverApiData(
    val title: String,
    val roadAddress: String,
    val mapx : Int,
    val mapy : Int
): Serializable {
}