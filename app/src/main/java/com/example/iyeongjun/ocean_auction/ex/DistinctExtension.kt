package com.example.iyeongjun.ocean_auction.ex

import com.example.iyeongjun.ocean_auction.api.model.storeModel.Items

fun Items.distinctName() = this.item.map { it.mxtrNm }.distinct()


fun com.example.iyeongjun.ocean_auction.api.model.mofModel.Items.distinctFish() = this.item.map { it.mprcStdCodeNm }.distinct()

