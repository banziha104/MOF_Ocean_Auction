package com.example.iyeongjun.ocean_auction.api.model.storeModel

import com.google.gson.annotations.SerializedName
data class Item(
    @SerializedName("mxtrCode") var mxtrCode: String,
    @SerializedName("mxtrNm") var mxtrNm: String,
    @SerializedName("csmtmktXode") var csmtmktXode: String,
    @SerializedName("csmtmktNm") var csmtmktNm: String,
    @SerializedName("csgnrCo") var csgnrCo: String,
    @SerializedName("fshrbtCo") var fshrbtCo: String,
    @SerializedName("sllllCo") var sllllCo: String,
    @SerializedName("prvyyTotCnsgnAmount") var prvyyTotCnsgnAmount: String
)