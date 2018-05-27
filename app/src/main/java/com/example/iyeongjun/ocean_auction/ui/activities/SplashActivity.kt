package com.example.iyeongjun.ocean_auction.ui.activities

import android.os.Bundle
import com.example.iyeongjun.ocean_auction.R
import com.example.iyeongjun.ocean_auction.api.MofSingleton
import com.example.iyeongjun.ocean_auction.api.inter.MofApi
import com.example.iyeongjun.ocean_auction.api.model.mofModel.MofModel
import com.example.iyeongjun.ocean_auction.ex.isoToUtf8
import com.google.gson.Gson
import dagger.android.support.DaggerAppCompatActivity
import okhttp3.ResponseBody
import org.jetbrains.anko.AnkoLogger
import org.json.XML
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class SplashActivity : DaggerAppCompatActivity(), AnkoLogger {
    @Inject lateinit var api : MofApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        api.getMOFData().enqueue(object : Callback<ResponseBody> {
            override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
                t?.printStackTrace()
            }
            override fun onResponse(call: Call<ResponseBody>?, response: Response<ResponseBody>?) {

                try {
                    var a = response?.body()?.string()
                    val temp1 = a!!.isoToUtf8()
                    var jsonObj = XML.toJSONObject(temp1).toString()
                    MofSingleton.mofdata = Gson().fromJson(jsonObj, MofModel::class.java)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        })
    }
}
