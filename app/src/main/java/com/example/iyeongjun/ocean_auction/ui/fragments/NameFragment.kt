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
import com.example.iyeongjun.ocean_auction.adapter.recycler.NameRecyclerAdapter
import com.example.iyeongjun.ocean_auction.api.model.storeModel.StoreModel
import kotlinx.android.synthetic.main.fragment_name.*

@SuppressLint("ValidFragment")
class NameFragment constructor(val data : StoreModel,val con : Context) : Fragment()  {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_name,container,false)
    }

    override fun onResume() {
        super.onResume()
        nameRecyclerview.apply{
            adapter = NameRecyclerAdapter(data,con)
            layoutManager = LinearLayoutManager(activity)
        }
    }
}
