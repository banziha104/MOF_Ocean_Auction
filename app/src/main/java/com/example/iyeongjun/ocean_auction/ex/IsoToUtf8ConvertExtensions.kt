package com.example.iyeongjun.ocean_auction.ex

import java.nio.charset.Charset

fun String.isoToUtf8() : String {
    var byteArray : ByteArray =  String(this.toByteArray(), Charset.forName("UTF-8")).toByteArray(Charset.forName("ISO-8859-1"))
    return String(byteArray)
}

fun String.makePair() : Pair<String, String>{
    var temp  = this.split("/")
    return Pair(temp[0],temp[1])
}