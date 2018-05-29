package com.example.iyeongjun.ocean_auction.ex

import com.example.iyeongjun.ocean_auction.api.MofSingleton
import com.example.iyeongjun.ocean_auction.api.model.mofModel.MofModel
import com.google.gson.Gson
import org.json.XML
import java.nio.charset.Charset

fun String.toMofModel() : MofModel {
    var byteArray : ByteArray =  String(this.toByteArray(), Charset.forName("UTF-8")).toByteArray(Charset.forName("ISO-8859-1"))
    var jsonObj = XML.toJSONObject(String(byteArray)).toString()
    return Gson().fromJson(jsonObj, MofModel::class.java)
}

fun String.isoToUtf8() : String {
    var byteArray : ByteArray =  String(this.toByteArray(), Charset.forName("UTF-8")).toByteArray(Charset.forName("ISO-8859-1"))
    return String(byteArray)
}

fun String.makePair() : Pair<String, String>{
    var temp  = this.split("/")
    return Pair(temp[0],temp[1])
}