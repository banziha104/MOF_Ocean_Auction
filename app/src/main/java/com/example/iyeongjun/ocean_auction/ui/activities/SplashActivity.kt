package com.example.iyeongjun.ocean_auction.ui.activities

import android.Manifest
import android.os.Bundle
import com.example.iyeongjun.ocean_auction.R
import com.example.iyeongjun.ocean_auction.api.MofSingleton
import com.example.iyeongjun.ocean_auction.api.inter.MofApi
import com.example.iyeongjun.ocean_auction.api.model.mofModel.MofModel
import com.example.iyeongjun.ocean_auction.api.model.storeModel.StoreModel
import com.example.iyeongjun.ocean_auction.ex.toMofModel
import com.example.iyeongjun.ocean_auction.util.PermissionController
import com.google.gson.Gson
import dagger.android.support.DaggerAppCompatActivity
import okhttp3.ResponseBody
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.startActivity
import org.json.XML
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class SplashActivity : DaggerAppCompatActivity(), AnkoLogger,PermissionController.CallBack {

    @Inject lateinit var api : MofApi
    @Inject lateinit var storeModel: StoreModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        requestPermission()
    }

    // 권한 습득후 초기화
    override fun init() {
        info("init")
        setMofData()
    }

    private fun requestPermission() {
        PermissionController(this,arrayOf(Manifest.permission.ACCESS_FINE_LOCATION)).checkVersion()
    }
    private fun setMofData(){
        api.getMOFData().enqueue(object : Callback<ResponseBody> {
            override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
                t?.printStackTrace()
            }
            override fun onResponse(call: Call<ResponseBody>?, response: Response<ResponseBody>?) {

                try {
                    MofSingleton.mofdata = response?.body()?.string()!!.toMofModel()
                    startActivity<MainActivity>()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        })
    }
}
