package com.example.iyeongjun.ocean_auction.di

import android.content.Context
import com.example.iyeongjun.ocean_auction.api.StoreObject
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule{

    @Provides
    @Singleton
    fun provideStoreModel(context : Context) = StoreObject(context = context).makeStoreJson()
}