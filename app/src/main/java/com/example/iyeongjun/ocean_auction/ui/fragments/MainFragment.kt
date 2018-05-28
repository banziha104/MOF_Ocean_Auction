package com.example.iyeongjun.ocean_auction.ui.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.iyeongjun.ocean_auction.R
import com.example.iyeongjun.ocean_auction.adapter.recycler.MainRecyclerAdapter
import com.example.iyeongjun.ocean_auction.api.MofSingleton
import kotlinx.android.synthetic.main.fragment_main.*
import org.jetbrains.anko.AnkoLogger


class MainFragment : Fragment(), AnkoLogger {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main,container,false)
    }

    override fun onResume() {
        super.onResume()
        mainRecyclerview.adapter = MainRecyclerAdapter(MofSingleton.mofdata!!)
        mainRecyclerview.layoutManager = LinearLayoutManager(activity)
    }
}
