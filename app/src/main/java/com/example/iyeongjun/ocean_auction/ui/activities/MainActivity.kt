package com.example.iyeongjun.ocean_auction.ui.activities

import android.Manifest
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.iyeongjun.ocean_auction.R
import com.example.iyeongjun.ocean_auction.util.PermissionController
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.debug

class MainActivity : AppCompatActivity(), AnkoLogger, PermissionController.CallBack{

    // 권한 습득후 초기화
    override fun init() {
        debug { "init" }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestPermission()

    }

    private fun requestPermission(){
        PermissionController(this,
                arrayOf(Manifest.permission.CAMERA,
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.READ_EXTERNAL_STORAGE)).checkVersion()
    }
}
