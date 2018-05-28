package com.example.iyeongjun.ocean_auction.api.model.mofModel

import com.google.gson.annotations.SerializedName
data class Body(
        @SerializedName("items") var items: Items,
        @SerializedName("totalCount") var totalCount: Int
)