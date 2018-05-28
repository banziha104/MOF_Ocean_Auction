package com.example.iyeongjun.ocean_auction.adapter.recycler

import android.app.Activity
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.iyeongjun.ocean_auction.R
import com.example.iyeongjun.ocean_auction.ui.activities.DetailActivity
import org.jetbrains.anko.startActivity

class FishRecyclerAdapter( item : List<String>, val context: Context) : RecyclerView.Adapter<FishViewHolder>() {
    val item = item

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FishViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_fish , parent, false)
        return FishViewHolder(view)
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: FishViewHolder, position: Int) {
        holder.position = position
        holder.context = context
        holder.txtTitle.text = item[position]
    }

}
class FishViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
    var position : Int? = null
    var context : Context? = null

    var txtTitle = itemView.findViewById<TextView>(R.id.txtFishTitle)

    init { bind() }

    fun bind(){
        itemView.setOnClickListener { context!!.startActivity<DetailActivity>() }
    }
}