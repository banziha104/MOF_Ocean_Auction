package com.example.iyeongjun.ocean_auction.ui.activities

//import com.example.iyeongjun.ocean_auction.api.model.Items
import android.Manifest
import android.icu.util.Calendar
import android.os.Bundle
import android.text.format.Time
import com.example.iyeongjun.ocean_auction.R
import com.example.iyeongjun.ocean_auction.api.inter.MofApi
import com.example.iyeongjun.ocean_auction.api.model.MofModel
import com.example.iyeongjun.ocean_auction.const.AUTH_KEY
import com.example.iyeongjun.ocean_auction.const.SERVER_URL
import com.example.iyeongjun.ocean_auction.ex.isoToUtf8
import com.example.iyeongjun.ocean_auction.util.PermissionController
import com.google.gson.Gson
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import okhttp3.ResponseBody
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.json.XML
import org.simpleframework.xml.convert.AnnotationStrategy
import org.simpleframework.xml.core.Persister
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import java.time.LocalDate.now
import java.time.LocalDateTime
import java.util.*
import javax.inject.Inject


class MainActivity : DaggerAppCompatActivity(), AnkoLogger, PermissionController.CallBack {

    @Inject lateinit var api : MofApi
    @Inject lateinit var eventBus : BehaviorSubject<String>

    // 권한 습득후 초기화
    override fun init() {
        info("init")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestPermission()
        info(Time().setToNow())
        api
                .getMOFData(AUTH_KEY,100,1,20180303,20180305)
                    .enqueue(object : Callback<ResponseBody> {
                        override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
                            t?.printStackTrace()
                        }

                        override fun onResponse(call: Call<ResponseBody>?, response: Response<ResponseBody>?) {

                            try {
                                var a = response?.body()?.string()
                                val temp1 = a!!.isoToUtf8()
                                var jsonObj = XML.toJSONObject(temp1).toString()
                                val result = Gson().fromJson(jsonObj, MofModel::class.java)
                                info(result)

                            } catch (e: Exception) {
                                e.printStackTrace()
                            }
                        }
        })
    }

    private fun requestPermission() {
        PermissionController(this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION)).checkVersion()
    }


    private fun getData(){
        info("========check this=============")
        val client = Retrofit.Builder()
                .baseUrl(SERVER_URL)
                .addConverterFactory(SimpleXmlConverterFactory.createNonStrict(Persister(AnnotationStrategy())))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build()
                .create(MofApi::class.java)
        client.getMOFData(AUTH_KEY, 3, 1, 20150320, 20150322)
                .enqueue(object : Callback<ResponseBody>{
                    override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
                        t?.printStackTrace()
                        info("실패다")
                    }

                    override fun onResponse(call: Call<ResponseBody>?, response: Response<ResponseBody>?) {

                        try {
                            var a = response?.body()?.string()
                            val temp1 = a!!.isoToUtf8()
                            var jsonObj = XML.toJSONObject(temp1).toString()
                            var data = Gson().fromJson(jsonObj, MofModel::class.java)
                            info(data.response.body.items.item[0].csmtDe)
                        }catch (e : Exception){
                            info("error")
                            e.printStackTrace()
                        }
                    }
                })
    }

}
