package com.example.iyeongjun.ocean_auction.adapter.recycler

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.iyeongjun.ocean_auction.R
import com.example.iyeongjun.ocean_auction.api.model.mofModel.Item
import com.example.iyeongjun.ocean_auction.api.model.mofModel.MofModel
import com.example.iyeongjun.ocean_auction.single.dataSingleton
import com.example.iyeongjun.ocean_auction.ui.activities.DetailActivity
import com.example.iyeongjun.ocean_auction.ui.activities.SelectActivity
import org.jetbrains.anko.startActivity
import org.w3c.dom.Text

class MainRecyclerAdapter( item : MofModel, val context : Context) : RecyclerView.Adapter<MainViewHolder>() {
    val item = item.response.body.items.item

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_main , parent, false)
        return MainViewHolder(view)
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val temp : List<Pair<String, String>> = listOf()
        for(i in 0..6) {
            //TODO : 여기
        }
        holder.item = item[position]
        holder.context = context
        holder.txtTitle.text = "   "+item[position].mxtrNm
        holder.txtSubtitle.text = "   "+item[position].csmtmktNm + " · " +item[position].mprcStdCodeNm + " · 최고가 : " + item[position].hghpc
    }

}
class MainViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
    var item : Item? = null
    var context : Context? = null
    val txtTitle = itemView.findViewById<TextView>(R.id.txtMainTitle)
    val txtSubtitle = itemView.findViewById<TextView>(R.id.txtMainSubtitle)
    init { bind() }

    fun bind() {
        itemView.setOnClickListener {
            dataSingleton.storeName  = item!!.mxtrNm
            context!!.startActivity<SelectActivity>()
        }
    }

}