package com.example.iyeongjun.ocean_auction.util

import android.annotation.TargetApi
import android.content.pm.PackageManager
import android.os.Build
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.debug
import javax.security.auth.callback.Callback

class PermissionController(val activity: AppCompatActivity, val permissions: Array<String>) : AnkoLogger {

    companion object {
        private val REQ_FLAG  = 10005
    }

    fun checkVersion() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkPermission()
        } else {
            callInit(activity)
        }

    }


    @TargetApi(Build.VERSION_CODES.M)
    private fun checkPermission() {
        var isGranted = true
        debug("Start Permission Check")

        for (permssion in permissions) {
            if (activity.checkSelfPermission(permssion) != PackageManager.PERMISSION_GRANTED) {
                isGranted = false
                break
            }
        }

        if (!isGranted) {
            debug { "request Permssion" }
            activity.requestPermissions(permissions, REQ_FLAG)
        } else{
            debug { "it's ok" }
        }

    }

    private fun callInit(activity: AppCompatActivity){
        if(activity is Callback){
            (activity as CallBack).init()
        } else {
            throw RuntimeException("must implement this.CallBack")
        }
    }
    interface CallBack{
        fun init()
    }
}