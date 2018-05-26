package com.example.iyeongjun.ocean_auction.api.inter

//import com.example.iyeongjun.ocean_auction.api.model.MofModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MofApi {
    @GET("/1192000/openapi/service/ManageAcst0400Service/getAcst0400List")
    fun getMOFData(
            @Query("serviceKey", encoded = true) serviceKey: String,
            @Query("numOfRows") numOfRows: Int,
            @Query("pageNo") pageNo: Int,
            @Query("fromDt") fromDt: Int,
            @Query("toDt") toDt: Int
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
            @Query("serviceKey", encoded = true) serviceKey: String,
            @Query("numOfRows") numOfRows: Int,
            @Query("pageNo") pageNo: Int,
            @Query("fromDt") fromDt: Int,
            @Query("toDt") toDt: Int,
            @Query("mprcStdCode") mprcStdCode: Int
    ): Call<ResponseBody>


}