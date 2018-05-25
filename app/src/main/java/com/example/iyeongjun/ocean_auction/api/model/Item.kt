package com.example.iyeongjun.ocean_auction.api.model

import com.google.gson.annotations.SerializedName
data class Item(
    @SerializedName("csmtDe") var csmtDe: Int,
    @SerializedName("mxtrCode") var mxtrCode: Int,
    @SerializedName("mxtrNm") var mxtrNm: String,
    @SerializedName("csmtmktCode") var csmtmktCode: Int,
    @SerializedName("csmtmktNm") var csmtmktNm: String,
    @SerializedName("mprcStdCode") var mprcStdCode: Int,
    @SerializedName("mprcStdCodeNm") var mprcStdCodeNm: String,
    @SerializedName("kdfshSttusCode") var kdfshSttusCode: Int,
    @SerializedName("kdfshSttusNm") var kdfshSttusNm: String,
    @SerializedName("goodsStndrdNm") var goodsStndrdNm: String,
    @SerializedName("goodsUnitNm") var goodsUnitNm: String,
    @SerializedName("hghpc") var hghpc: Int,
    @SerializedName("lprc") var lprc: Int
)