package com.example.iyeongjun.ocean_auction.di

import com.example.iyeongjun.ocean_auction.ui.activities.MainActivity
import com.example.iyeongjun.ocean_auction.ui.activities.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by iyeongjun on 2018. 3. 4..
 */

@Module
abstract class ActivityBinder{

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf())
    abstract fun bindMainActivity() : MainActivity

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf())
    abstract fun bindSplashActivity() : SplashActivity


//    @ContributesAndroidInjector(modules = arrayOf(ApiModule::class))
//    abstract fun bindSecondActivity() : SplashActivity

}