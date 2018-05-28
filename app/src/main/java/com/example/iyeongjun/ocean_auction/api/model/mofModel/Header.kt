package com.example.iyeongjun.ocean_auction.api.model.mofModel

import com.google.gson.annotations.SerializedName
data class Header(
    @SerializedName("title") var title: String,
    @SerializedName("resultCode") var resultCode: String,
    @SerializedName("resultMsg") var resultMsg: String
)