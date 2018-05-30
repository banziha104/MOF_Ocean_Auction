package com.example.iyeongjun.ocean_auction.adapter.recycler

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.iyeongjun.ocean_auction.R
import com.example.iyeongjun.ocean_auction.api.model.storeModel.StoreModel
import com.example.iyeongjun.ocean_auction.ex.distinctName
import com.example.iyeongjun.ocean_auction.single.dataSingleton
import com.example.iyeongjun.ocean_auction.ui.activities.DetailActivity
import com.example.iyeongjun.ocean_auction.ui.activities.SelectActivity
import org.jetbrains.anko.startActivity

class NameRecyclerAdapter(val items : StoreModel, val context : Context) : RecyclerView.Adapter<NameViewHolder>() {
    val item = items.response.body.items.distinctName()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_name , parent, false)
        return NameViewHolder(view)
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: NameViewHolder, position: Int){
        var result = "  "
        items.response.body.items.item.filter { it.mxtrNm == item[position] }.forEach{ result += it.csmtmktNm + " · "}

        holder.item = item[position]
        holder.context = context
        holder.txtTitle.text = "  " + item[position]
        holder.txtSubTitle.text = result.substring(0, result.length - 2)
        Log.d("For문","${result.length} / ${result.substring(0,result.length - 2)}")

    }

}
class NameViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
    var item : String? = null
    var context : Context? = null
    var txtTitle = itemView.findViewById<TextView>(R.id.txtNameTitle)
    var txtSubTitle = itemView.findViewById<TextView>(R.id.txtNameSubtitle)
    init { bind() }

    fun bind(){
        itemView.setOnClickListener {
            dataSingleton.storeName = item!!
            context!!.startActivity<SelectActivity>()
        }
    }
}