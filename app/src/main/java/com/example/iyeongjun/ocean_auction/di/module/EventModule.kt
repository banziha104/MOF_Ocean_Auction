package com.example.iyeongjun.ocean_auction.di.module

import dagger.Module
import dagger.Provides
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Singleton

@Module
class EventModule{

    @Provides
    @Singleton
    fun provideEventBus() : BehaviorSubject<String> = BehaviorSubject.create()
}