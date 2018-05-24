package com.example.iyeongjun.ocean_auction

import android.content.Context
import android.support.multidex.MultiDex
import android.support.multidex.MultiDexApplication

class MultiDexApp : MultiDexApplication() {
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}