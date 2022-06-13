package com.example.travelplan_finalproject.naver

import android.content.Context
import com.example.travelplan_finalproject.api.DateDeserializer
import com.example.travelplan_finalproject.utils.ContextUtil
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.*


class NaverServerApi {


    companion object {


        private var retrofit2: Retrofit? = null
        private  val baseUrl2 = "https://openapi.naver.com/v1/"
        fun getRetrofit(context : Context): Retrofit {
        val naverClientId = "3S3FBRp0T5yGsWX5zmlV"
        val naverClientSecret = "2HPzpdAXcL"


        val interceptor = Interceptor {
            with(it) {
                val newRequest = request().newBuilder()
                    .addHeader("X-Naver-Client-Id", naverClientId)
                    .addHeader("X-Naver-Client-Secret", naverClientSecret)
                    .build()
                proceed(newRequest)
            }
        }

        val myClient = OkHttpClient.Builder().addInterceptor(interceptor).build()

        if (retrofit2 == null)
        {
            retrofit2 = Retrofit.Builder()
                .baseUrl(baseUrl2)
                .client(myClient)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        return retrofit2!!

    }

}
}