package com.example.iyeongjun.ocean_auction.adapter.recycler

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.iyeongjun.ocean_auction.R
import com.example.iyeongjun.ocean_auction.api.model.storeModel.StoreModel
import com.example.iyeongjun.ocean_auction.ex.distinctName
import com.example.iyeongjun.ocean_auction.ui.activities.DetailActivity
import com.example.iyeongjun.ocean_auction.ui.activities.SelectActivity
import org.jetbrains.anko.startActivity

class NameRecyclerAdapter( item : StoreModel, val context : Context) : RecyclerView.Adapter<NameViewHolder>() {
    val item = item.response.body.items.distinctName()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_name , parent, false)
        return NameViewHolder(view)
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: NameViewHolder, position: Int) {

        holder.postion = position
        holder.context = context
        holder.txtTitle.text = item[position]
    }

}
class NameViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
    var postion : Int? = null
    var context : Context? = null
    var txtTitle = itemView.findViewById<TextView>(R.id.txtNameTitle)

    init { bind() }

    fun bind(){
        itemView.setOnClickListener { context!!.startActivity<DetailActivity>() }
    }
}