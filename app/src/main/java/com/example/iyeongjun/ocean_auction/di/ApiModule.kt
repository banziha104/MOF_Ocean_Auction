package com.example.iyeongjun.ocean_auction.di

import com.example.iyeongjun.ocean_auction.api.inter.MofApi
import com.example.iyeongjun.ocean_auction.const.AUTH_KEY
import com.example.iyeongjun.ocean_auction.const.SERVER_URL
import dagger.Module
import dagger.Provides
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import org.simpleframework.xml.convert.AnnotationStrategy
import org.simpleframework.xml.core.Persister
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class ApiModule{
    @Provides
    @Singleton
    @Named("default")
    fun provideMofApi()
            = Observable.just(Retrofit.Builder()
            .baseUrl(SERVER_URL)
            .addConverterFactory(SimpleXmlConverterFactory.createNonStrict(Persister(AnnotationStrategy())))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
            .create(MofApi::class.java)
            .getMOFData(AUTH_KEY, 100, 1, 20150320, 20150322))

    @Provides
    @Singleton
    @Named("withStoreName")
    fun provideMofApiWithStore(name : String) = Observable.just(Retrofit.Builder()
            .baseUrl(SERVER_URL)
            .addConverterFactory(SimpleXmlConverterFactory.createNonStrict(Persister(AnnotationStrategy())))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
            .create(MofApi::class.java)
            .getMOFData(AUTH_KEY, 100, 1, 20150320, 20150322))

    @Provides
    @Singleton
    @Named("withFishName")
    fun provideMofApiWithFish(name : String) = Observable.just(Retrofit.Builder()
            .baseUrl(SERVER_URL)
            .addConverterFactory(SimpleXmlConverterFactory.createNonStrict(Persister(AnnotationStrategy())))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
            .create(MofApi::class.java)
            .getMOFData(AUTH_KEY, 100, 1, 20150320, 20150322))

}