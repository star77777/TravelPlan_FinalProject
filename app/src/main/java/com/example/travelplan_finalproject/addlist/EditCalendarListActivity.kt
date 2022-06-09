package com.example.travelplan_finalproject.addlist


import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.travelplan_finalproject.BaseActivity
import com.example.travelplan_finalproject.R
import com.example.travelplan_finalproject.databinding.ActivityEditCalendarListBinding
import java.text.SimpleDateFormat
import java.util.*

class EditCalendarListActivity : BaseActivity() {
    lateinit var binding: ActivityEditCalendarListBinding

    //    선택한 약속 일시를 저장할 멤버변수
    val mSelectedDateTime = Calendar.getInstance()  // 기본값 : 현재시간

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_edit_calendar_list)

        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        //가는 날
        binding.firstDateTxt.setOnClickListener {
//            날짜를 선택하고 할 일(인터페이스)를 작성
            val dl = object : DatePickerDialog.OnDateSetListener {
                override fun onDateSet(p0: DatePicker?, year: Int, month: Int, day: Int) {
                    mSelectedDateTime.set(year, month, day)

                    val sdf = SimpleDateFormat("yyyy. M. d (E)")
                    Log.d("선택된 시간", sdf.format(mSelectedDateTime.time))

                    binding.firstDateTxt.text = sdf.format(mSelectedDateTime.time)
                }
            }

//            DatePickerDialog 팝업
            val dpd = DatePickerDialog(
                mContext,
                dl,
                mSelectedDateTime.get(Calendar.YEAR),
                mSelectedDateTime.get(Calendar.MONTH),
                mSelectedDateTime.get(Calendar.DAY_OF_MONTH)
            )

            dpd.show()
        }
        //오늘날
        //            날짜 선택
        binding.lastDateTxt.setOnClickListener {
//            날짜를 선택하고 할 일(인터페이스)를 작성
            val dl = object : DatePickerDialog.OnDateSetListener {
                override fun onDateSet(p0: DatePicker?, year: Int, month: Int, day: Int) {
                    mSelectedDateTime.set(year, month, day)

                    val sdf = SimpleDateFormat("yyyy. M. d (E)")
                    Log.d("선택된 시간", sdf.format(mSelectedDateTime.time))

                    binding.lastDateTxt.text = sdf.format(mSelectedDateTime.time)
                }
            }

//            DatePickerDialog 팝업
            val dpd = DatePickerDialog(
                mContext,
                dl,
                mSelectedDateTime.get(Calendar.YEAR),
                mSelectedDateTime.get(Calendar.MONTH),
                mSelectedDateTime.get(Calendar.DAY_OF_MONTH)
            )

            dpd.show()
        }
        binding.addBtn.setOnClickListener {
            //            3. 날짜/시간이 선택이 되었는가?
//             =>날짜 / 기간 중 선택 안한게 있다면, 선택하라고 토스트 함수를 강제 종료하자.
            if (binding.firstDateTxt.text == "일자 선택") {
                Toast.makeText(mContext, "약속 일자를 선택하지 않았습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (binding.lastDateTxt.text == "일자 선택") {
                Toast.makeText(mContext, "약속 일자를 선택하지 않았습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

        }
    }

    override fun setValues() {
        titleTxt.text = "일정 등록하기"
    }
}