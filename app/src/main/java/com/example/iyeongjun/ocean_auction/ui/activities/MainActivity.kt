package com.example.iyeongjun.ocean_auction.ui.activities

//import com.example.iyeongjun.ocean_auction.api.model.MofModel.Items
import android.os.Bundle
import android.support.design.widget.TabLayout
import com.example.iyeongjun.ocean_auction.R
import com.example.iyeongjun.ocean_auction.adapter.pager.MainPagerAdapter
import com.example.iyeongjun.ocean_auction.api.model.storeModel.StoreModel
import com.example.iyeongjun.ocean_auction.res.tabClicekdImages
import com.example.iyeongjun.ocean_auction.res.tabDefaultImages
import com.example.iyeongjun.ocean_auction.res.tabNames
import com.example.iyeongjun.ocean_auction.ui.fragments.FishFragment
import com.example.iyeongjun.ocean_auction.ui.fragments.MainFragment
import com.example.iyeongjun.ocean_auction.ui.fragments.NameFragment
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.subjects.BehaviorSubject
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.AnkoLogger
import javax.inject.Inject


class MainActivity : DaggerAppCompatActivity(), AnkoLogger{

    @Inject lateinit var eventBus : BehaviorSubject<String>
    @Inject lateinit var storeData : StoreModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setViewPager()
    }



    private fun setViewPager() {
        mainViewpager.adapter = MainPagerAdapter(supportFragmentManager, listOf(MainFragment(),NameFragment(storeData),FishFragment()))
        for (i in 0..2) {
            if (i == 0) tab.addTab(tab.newTab().setIcon(tabClicekdImages[i]).setText(tabNames[i]))
            else tab.addTab(tab.newTab().setIcon(tabDefaultImages[i]).setText(tabNames[i]))
        }
        mainViewpager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab))
        tab.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(mainViewpager))
        tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tabs: TabLayout.Tab) {
                setSelectedIamge(tabs)
            }
            override fun onTabUnselected(tabs: TabLayout.Tab) {
                setUnSelectedIamge(tabs)
            }
            override fun onTabReselected(tabs: TabLayout.Tab) {

            }
        })
    }
    private fun setSelectedIamge(tabs : TabLayout.Tab) = tabs.setIcon(tabClicekdImages[tabs.position])
    private fun setUnSelectedIamge(tabs : TabLayout.Tab) = tabs.setIcon(tabDefaultImages[tabs.position])
}