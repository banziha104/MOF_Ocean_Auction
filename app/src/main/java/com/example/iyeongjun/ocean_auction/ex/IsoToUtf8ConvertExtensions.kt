package com.example.iyeongjun.ocean_auction.ex

import java.nio.charset.Charset

fun String.isoToUtf8() : String {
    var byteArray : ByteArray =  String(this.toByteArray(), Charset.forName("UTF-8")).toByteArray(Charset.forName("ISO-8859-1"))
    return String(byteArray)
}