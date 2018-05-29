package com.example.iyeongjun.ocean_auction.ui.activities

import android.os.Bundle
import com.example.iyeongjun.ocean_auction.R
import com.example.iyeongjun.ocean_auction.single.dataSingleton
import dagger.android.support.DaggerAppCompatActivity
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

class DetailActivity : DaggerAppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        info(dataSingleton.resultItem)
    }

    override fun onPause() {
        super.onPause()
        dataSingleton.apply {
            storeName = ""
            fishName = ""
        }
    }
}
