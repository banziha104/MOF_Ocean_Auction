package com.example.iyeongjun.ocean_auction.ui.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.iyeongjun.ocean_auction.R
import com.example.iyeongjun.ocean_auction.adapter.recycler.FishRecyclerAdapter
import com.example.iyeongjun.ocean_auction.res.fishName
import kotlinx.android.synthetic.main.fragment_fish.*

@SuppressLint("ValidFragment")
class FishFragment(val con : Context) : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_fish,container,false)
    }

    override fun onResume() {
        super.onResume()
        fishRecyclerview.apply {
            adapter = FishRecyclerAdapter(fishName,con)
            layoutManager = LinearLayoutManager(activity)
        }
    }
}
