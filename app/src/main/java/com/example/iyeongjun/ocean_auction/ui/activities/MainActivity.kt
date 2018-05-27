package com.example.iyeongjun.ocean_auction.ui.activities

//import com.example.iyeongjun.ocean_auction.api.model.MofModel.Items
import android.Manifest
import android.os.Bundle
import com.example.iyeongjun.ocean_auction.R
import com.example.iyeongjun.ocean_auction.adapter.pager.MainPagerAdapter
import com.example.iyeongjun.ocean_auction.api.inter.MofApi
import com.example.iyeongjun.ocean_auction.api.model.storeModel.StoreModel
import com.example.iyeongjun.ocean_auction.ex.distinctName
import com.example.iyeongjun.ocean_auction.ui.fragments.FishFragment
import com.example.iyeongjun.ocean_auction.ui.fragments.MainFragment
import com.example.iyeongjun.ocean_auction.ui.fragments.NameFragment
import com.example.iyeongjun.ocean_auction.util.PermissionController
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.subjects.BehaviorSubject
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import javax.inject.Inject


class MainActivity : DaggerAppCompatActivity(), AnkoLogger, PermissionController.CallBack {

    @Inject lateinit var api : MofApi
    @Inject lateinit var eventBus : BehaviorSubject<String>
    @Inject lateinit var storeModel: StoreModel

    // 권한 습득후 초기화
    override fun init() {
        info("init")
        setViewPager()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestPermission()
        val item = storeModel.response.body.items.distinctName()
    }



    private fun requestPermission() {
        PermissionController(this,arrayOf(Manifest.permission.ACCESS_FINE_LOCATION)).checkVersion()
    }
    private fun setViewPager() {
        mainViewpager.adapter = MainPagerAdapter(supportFragmentManager, listOf(MainFragment(),NameFragment(),FishFragment()))

    }

}