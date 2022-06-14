package com.example.travelplan_finalproject.addlist


import android.annotation.SuppressLint
import android.app.TimePickerDialog
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.View
import android.widget.ScrollView
import android.widget.TextView
import android.widget.TimePicker
import android.widget.Toast
import androidx.core.widget.NestedScrollView
import androidx.databinding.DataBindingUtil
import com.example.travelplan_finalproject.BaseActivity
import com.example.travelplan_finalproject.R
import com.example.travelplan_finalproject.databinding.ActivityEditTodoListBinding
import com.example.travelplan_finalproject.naver.ApIListNaver
import com.example.travelplan_finalproject.naver.BasicResponseNaver
import com.example.travelplan_finalproject.naver.NaverApiData
import com.example.travelplan_finalproject.naver.NaverServerApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import java.text.SimpleDateFormat
import java.util.*

class TodoListActivity : BaseActivity() {
    lateinit var binding: ActivityEditTodoListBinding

    var mPlaceList = ArrayList<NaverApiData>()

    //    선택한 약속 일시를 저장할 멤버변수
    val mSelectedDateTime2 = Calendar.getInstance()!!// 기본값 : 현재시간
    var mSelectedLatitude = 37.5779235853308
    var mSelectedLongitude = 127.033553463647


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_edit_todo_list)





        setupEvents()
        setValues()
    }


    @SuppressLint("ClickableViewAccessibility")
    override fun setupEvents() {
//            시간 선택
        binding.timeTxt.setOnClickListener {
            val tsl = object : TimePickerDialog.OnTimeSetListener {
                override fun onTimeSet(p0: TimePicker?, hour: Int, minute: Int) {
                    mSelectedDateTime2.set(Calendar.HOUR_OF_DAY, hour)
                    mSelectedDateTime2.set(Calendar.MINUTE, minute)

//                    오후 12:10 형태로 가공
                    val sdf = SimpleDateFormat("a h:mm")
                    binding.timeTxt.text = sdf.format(mSelectedDateTime2.time)

                }
            }

            TimePickerDialog(
                mContext,
                tsl,
                mSelectedDateTime2.get(Calendar.HOUR_OF_DAY),
                mSelectedDateTime2.get(Calendar.MINUTE),
                false
            ).show()
        }
        binding.placeSearchBtn.setOnClickListener {
            val inputKeyword = binding.placeNameEdt.text.toString()
            if (inputKeyword.length < 2) {
                Toast.makeText(this, "검색어는 두글자 이상 작성해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val retrofit2 = NaverServerApi.getRetrofit(this)
            val apIListNaver = retrofit2.create(ApIListNaver::class.java)



            apIListNaver.getSearchlocal(inputKeyword, 5)
                .enqueue(object : Callback<BasicResponseNaver> {
                    override fun onResponse(
                        call: Call<BasicResponseNaver>,
                        response: Response<BasicResponseNaver>
                    ) {
                        Log.d("json", response.toString())

                        if (response.isSuccessful) {
                            Log.d("성공", response.body().toString())

                            fun bind (item : NaverApiData) {

                                binding.placeTitleTxt.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                                    Html.fromHtml(item.title, Html.FROM_HTML_MODE_LEGACY).toString()
                                } else {
                                    Html.fromHtml(item.title).toString()    }

                                binding.placeAddressTxt.text = item.roadAddress

                                binding.placeSearchBtn.setOnClickListener {
                                    //스크롤 뷰 참조하기
                                    var myText:TextView =findViewById(R.id.placeTitleTxt)
                                    myText.text = Html.fromHtml(item.title, Html.FROM_HTML_MODE_LEGACY).toString()
                                   // ScrollView NestedScrollView= findViewById(R.id.NestedScrollView);

                                    var myAddressText:TextView =findViewById(R.id.placeAddressTxt)
                                    myAddressText.text =  item.roadAddress
                                    //스크롤뷰의 스크롤위치를 가장 아래쪽으로 이동
                                   // NestedScrollView.fullScroll(ScrollView.FOCUS_DOWN);
                                }

                            }
                            mPlaceList.clear()
                            mPlaceList.addAll(response.body()!!.items)

                        }
                    }

                    override fun onFailure(call: Call<BasicResponseNaver>, t: Throwable) {
                        Log.d("서버 실패", t.toString())
                    }
                })
        }

    }

    override fun setValues() {

    }
}


