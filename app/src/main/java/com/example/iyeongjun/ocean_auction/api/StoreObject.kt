package com.example.iyeongjun.ocean_auction.api

import android.content.Context
import com.example.iyeongjun.ocean_auction.api.model.storeModel.StoreModel
import com.google.gson.Gson

class StoreObject(val context : Context){
    fun makeStoreJson() : StoreModel{
        var inputStream = context.assets.open("storename.json").bufferedReader().use {
            it.readText()
        }
        return Gson().fromJson(inputStream,StoreModel::class.java)
    }
}