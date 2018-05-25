package com.example.iyeongjun.ocean_auction.api

class RequestMof{
//    fun reqeust() : MofModel? {
//        val result : MofModel?
//        val client = Retrofit.Builder()
//                .baseUrl(SERVER_URL)
//                .addConverterFactory(SimpleXmlConverterFactory.createNonStrict(Persister(AnnotationStrategy())))
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
//                .build()
//                .create(MofApi::class.java)
//                .getMOFData(AUTH_KEY, 3, 1, 20150320, 20150322)
//                .enqueue(object : Callback<ResponseBody> {
//                    override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
//                        t?.printStackTrace()
//                    }
//
//                    override fun onResponse(call: Call<ResponseBody>?, response: Response<ResponseBody>?) {
//
//                        try {
//                            var a = response?.body()?.string()
//                            val temp1 = a!!.isoToUtf8()
//                            var jsonObj = XML.toJSONObject(temp1).toString()
//                            result = Gson().fromJson(jsonObj, MofModel::class.java)
//
//                        }catch (e : Exception){
//                            e.printStackTrace()
//                        }
//                    }
//                })
//        return result
//    }
}