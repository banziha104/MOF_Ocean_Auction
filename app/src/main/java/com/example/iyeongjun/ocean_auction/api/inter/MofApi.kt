package com.example.iyeongjun.ocean_auction.api.inter

//import com.example.iyeongjun.ocean_auction.api.model.MofModel.MofModel
import com.example.iyeongjun.ocean_auction.const.AUTH_KEY
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MofApi {
    @GET("/1192000/openapi/service/ManageAcst0400Service/getAcst0400List")
    fun getMOFData(
            @Query("serviceKey", encoded = true) serviceKey: String = AUTH_KEY,
            @Query("numOfRows") numOfRows: Int = 50,
            @Query("pageNo") pageNo: Int = 1,
            @Query("fromDt") fromDt: Int = 20180303,
            @Query("toDt") toDt: Int = 20180305
    ): Call<ResponseBody>

    @GET("/1192000/openapi/service/ManageAcst0400Service/getAcst0400List")
    fun getMOFDataWithStoreCode(
            @Query("serviceKey", encoded = true) serviceKey: String,
            @Query("numOfRows") numOfRows: Int,
            @Query("pageNo") pageNo: Int,
            @Query("fromDt") fromDt: Int,
            @Query("toDt") toDt: Int,
            @Query("mxtrCode") mxtrCode: Int
    ): Call<ResponseBody>

    @GET("/1192000/openapi/service/ManageAcst0400Service/getAcst0400List")
    fun getMOFDataWithFishCode(
            @Query("serviceKey", encoded = true) serviceKey: String = AUTH_KEY,
            @Query("numOfRows") numOfRows: Int = 50,
            @Query("pageNo") pageNo: Int = 1,
            @Query("fromDt") fromDt: Int = 20180303,
            @Query("toDt") toDt: Int = 20180305,
            @Query("mprcStdCode") mprcStdCode: String,
            @Query("mxtrCode") mxtrCode: String
    ): Call<ResponseBody>


}