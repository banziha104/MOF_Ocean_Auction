package com.example.iyeongjun.ocean_auction.di

import android.content.Context
import com.example.iyeongjun.ocean_auction.Dagger2App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        ActivityBinder::class
        ,ContextModule::class
        ,AndroidSupportInjectionModule::class
        ,EventModule::class
        ,AppModule::class
))
interface AppComponent : AndroidInjector<Dagger2App>{

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: Context): Builder

        fun build(): AppComponent
    }
}