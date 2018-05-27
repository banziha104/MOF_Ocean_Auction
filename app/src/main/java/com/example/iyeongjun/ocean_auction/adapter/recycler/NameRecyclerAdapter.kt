package com.example.iyeongjun.ocean_auction.adapter.recycler

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.iyeongjun.ocean_auction.R

class NameRecyclerAdapter( item : List<String> ) : RecyclerView.Adapter<NameViewHolder>() {
    val item = item

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_main , parent, false)
        return NameViewHolder(view)
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: NameViewHolder, position: Int) {
        holder.txtTitle.text = item[position]
    }

}
class NameViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
    var txtTitle = itemView.findViewById<TextView>(R.id.txtNameTitle)
}