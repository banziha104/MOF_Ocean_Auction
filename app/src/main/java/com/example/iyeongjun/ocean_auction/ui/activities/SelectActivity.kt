package com.example.iyeongjun.ocean_auction.ui.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.iyeongjun.ocean_auction.R
import com.example.iyeongjun.ocean_auction.api.inter.MofApi
import com.example.iyeongjun.ocean_auction.ex.toMofModel
import com.example.iyeongjun.ocean_auction.single.dataSingleton
import dagger.android.support.DaggerAppCompatActivity
import okhttp3.ResponseBody
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class SelectActivity : DaggerAppCompatActivity(), AnkoLogger {

    @Inject lateinit var api : MofApi
    var hasStore = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select)
        checkData()
        returnApi().enqueue(object : Callback<ResponseBody>{
            override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<ResponseBody>?, response: Response<ResponseBody>?) {
                val data = response?.body()?.string()?.toMofModel()
                // TODO : 영준씨 여기부터합시다
            }
        })
    }

    private fun checkData(){
        if (dataSingleton.storeName === "" && !(dataSingleton.fishName === "")) hasStore = false
        else if (dataSingleton.fishName === "" && !(dataSingleton.storeName === "")) hasStore = true
        else info("아무 타입이 아님")

    }

    private fun returnApi() : Call<ResponseBody> {
        if (hasStore) return api.getMOFDataWithStorename(csmtmktNm = dataSingleton.storeName)
        else return api.getMOFDataWithFishname(mprcStdCode = dataSingleton.fishName )
    }
}
