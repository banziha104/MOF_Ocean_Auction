package com.example.iyeongjun.ocean_auction.api.model.storeModel

import com.google.gson.annotations.SerializedName
data class Response(
    @SerializedName("header") var header: Header,
    @SerializedName("body") var body: Body
)