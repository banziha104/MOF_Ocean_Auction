package com.example.iyeongjun.ocean_auction.adapter.recycler

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.iyeongjun.ocean_auction.R
import com.example.iyeongjun.ocean_auction.api.model.mofModel.MofModel
import com.example.iyeongjun.ocean_auction.ui.activities.DetailActivity
import org.jetbrains.anko.startActivity

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
        holder.position = position
        holder.context = context
        holder.txtTitle.text = item[position].mxtrNm
    }

}
class MainViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
    var position : Int? = null
    var context : Context? = null
    var txtTitle = itemView.findViewById<TextView>(R.id.txtMainTitle)

    init { bind() }

    fun bind(){
        itemView.setOnClickListener { context!!.startActivity<DetailActivity>() }
    }
}