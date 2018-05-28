package com.example.iyeongjun.ocean_auction.di.module

import com.example.iyeongjun.ocean_auction.api.inter.MofApi
import com.example.iyeongjun.ocean_auction.const.SERVER_URL
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import org.simpleframework.xml.convert.AnnotationStrategy
import org.simpleframework.xml.core.Persister
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
class ApiModule{

    @Singleton
    @Provides
    fun provideMofApi()
            = Retrofit.Builder()
            .baseUrl(SERVER_URL)
            .client(
                    OkHttpClient.Builder()
                            .connectTimeout(20, TimeUnit.MINUTES)
                            .readTimeout(30, TimeUnit.SECONDS)
                            .writeTimeout(20, TimeUnit.SECONDS)
                            .build())
            .addConverterFactory(SimpleXmlConverterFactory.createNonStrict(Persister(AnnotationStrategy())))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
            .create(MofApi::class.java)
}