package com.example.iyeongjun.ocean_auction.api.model.storeModel

import com.google.gson.annotations.SerializedName
data class Items(
    @SerializedName("item") var item: List<Item>
)