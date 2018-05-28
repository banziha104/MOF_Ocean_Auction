package com.example.iyeongjun.ocean_auction.ui.activities

import android.os.Bundle
import com.example.iyeongjun.ocean_auction.R
import com.example.iyeongjun.ocean_auction.single.dataSingleton
import dagger.android.support.DaggerAppCompatActivity

class DetailActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
    }

    override fun onPause() {
        super.onPause()
        dataSingleton.apply {
            storeName = ""
            fishName = ""
        }
        dataSingleton.apply {  }
    }
}
