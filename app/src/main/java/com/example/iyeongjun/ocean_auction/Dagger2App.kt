package com.example.iyeongjun.ocean_auction

import com.example.iyeongjun.ocean_auction.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

/**
 * Created by iyeongjun on 2018. 3. 3..
 */

class Dagger2App : DaggerApplication(){
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }
}