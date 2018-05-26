package com.example.iyeongjun.ocean_auction.api.model

import com.google.gson.annotations.SerializedName
data class Item(
    @SerializedName("csmtDe") var csmtDe: Int,
    @SerializedName("mxtrCode") var mxtrCode: String,
    @SerializedName("mxtrNm") var mxtrNm: String,
    @SerializedName("csmtmktCode") var csmtmktCode: String,
    @SerializedName("csmtmktNm") var csmtmktNm: String,
    @SerializedName("mprcStdCode") var mprcStdCode: String,
    @SerializedName("mprcStdCodeNm") var mprcStdCodeNm: String,
    @SerializedName("kdfshSttusCode") var kdfshSttusCode: String,
    @SerializedName("kdfshSttusNm") var kdfshSttusNm: String,
    @SerializedName("goodsStndrdNm") var goodsStndrdNm: String,
    @SerializedName("goodsUnitNm") var goodsUnitNm: String,
    @SerializedName("hghpc") var hghpc: Int,
    @SerializedName("lprc") var lprc: Int
)