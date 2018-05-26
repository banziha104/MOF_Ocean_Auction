package com.example.iyeongjun.ocean_auction.di

import com.example.iyeongjun.ocean_auction.di.ui.MainModule
import com.example.iyeongjun.ocean_auction.ui.activities.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton

/**
 * Created by iyeongjun on 2018. 3. 4..
 */

@Module
abstract class ActivityBinder{

    @ContributesAndroidInjector(modules = arrayOf(MainModule::class))
    abstract fun bindMainActivity() : MainActivity


//    @ContributesAndroidInjector(modules = arrayOf(ApiModule::class))
//    abstract fun bindSecondActivity() : SplashActivity

}