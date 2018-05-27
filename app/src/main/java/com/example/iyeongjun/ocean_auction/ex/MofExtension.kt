package com.example.iyeongjun.ocean_auction.ex

import com.example.iyeongjun.ocean_auction.api.model.mofModel.MofModel
import com.google.gson.Gson
import okhttp3.ResponseBody
import org.json.XML
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun Call<ResponseBody>.makeMofData() : MofModel? {
    var result : MofModel? = null
    this.enqueue(object : Callback<ResponseBody> {
                    override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
                        t?.printStackTrace()
                    }

                    override fun onResponse(call: Call<ResponseBody>?, response: Response<ResponseBody>?) {

                        try {
                            var a = response?.body()?.string()
                            val temp1 = a!!.isoToUtf8()
                            var jsonObj = XML.toJSONObject(temp1).toString()
                            result = Gson().fromJson(jsonObj, MofModel::class.java)
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }
                })
    return result
}