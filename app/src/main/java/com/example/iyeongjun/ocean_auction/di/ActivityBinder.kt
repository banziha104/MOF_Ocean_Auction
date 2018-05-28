package com.example.iyeongjun.ocean_auction.di

import com.example.iyeongjun.ocean_auction.di.scopes.PerActivity
import com.example.iyeongjun.ocean_auction.ui.activities.DetailActivity
import com.example.iyeongjun.ocean_auction.ui.activities.MainActivity
import com.example.iyeongjun.ocean_auction.ui.activities.SelectActivity
import com.example.iyeongjun.ocean_auction.ui.activities.SplashActivity
import com.example.iyeongjun.ocean_auction.ui.fragments.FishFragment
import com.example.iyeongjun.ocean_auction.ui.fragments.MainFragment
import com.example.iyeongjun.ocean_auction.ui.fragments.NameFragment
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


    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf())
    abstract fun bindDetailActivity() : DetailActivity

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf())
    abstract fun bindSelectActivity() : SelectActivity

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf())
    abstract fun bindMainFragment() : MainFragment

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf())
    abstract fun bindFishFragment() : FishFragment

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf())
    abstract fun bindNameFragment() : NameFragment

//    @ContributesAndroidInjector(modules = arrayOf(ApiModule::class))
//    abstract fun bindSecondActivity() : SplashActivity

}