package com.example.iyeongjun.ocean_auction.adapter.recycler

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.iyeongjun.ocean_auction.R
import com.example.iyeongjun.ocean_auction.api.model.mofModel.Item
import com.example.iyeongjun.ocean_auction.api.model.mofModel.MofModel
import com.example.iyeongjun.ocean_auction.api.model.storeModel.StoreModel
import com.example.iyeongjun.ocean_auction.ex.distinctName
import com.example.iyeongjun.ocean_auction.single.dataSingleton
import com.example.iyeongjun.ocean_auction.ui.activities.DetailActivity
import com.example.iyeongjun.ocean_auction.ui.activities.SelectActivity
import org.jetbrains.anko.startActivity

class SelectRecyclerAdapterStore(val items : MofModel, val context : Context) : RecyclerView.Adapter<SelectStoreViewHolder>() {
    val item = items.response.body.items.item

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectStoreViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_name , parent, false)
        return SelectStoreViewHolder(view)
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: SelectStoreViewHolder, position: Int){
        var result = "  "
        var temp = item.filter { it.mprcStdCodeNm == dataSingleton.fishName }
        temp.forEach{ result += it.csmtmktNm + " · "}

        holder.item = temp[0]
        holder.context = context
        holder.txtTitle.text = "  " + temp[0].mxtrNm
        holder.txtSubTitle.text = result.substring(0, result.length - 2)
        Log.d("For문","${result.length} / ${result.substring(0,result.length - 2)}")
    }

}
class SelectStoreViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
    var item : Item? = null
    var context : Context? = null
    var txtTitle = itemView.findViewById<TextView>(R.id.txtNameTitle)
    var txtSubTitle = itemView.findViewById<TextView>(R.id.txtNameSubtitle)
    init { bind() }

    fun bind(){
        itemView.setOnClickListener {
            dataSingleton.resultItem = item!!
            context!!.startActivity<DetailActivity>()
        }
    }
}