package com.example.iyeongjun.ocean_auction.adapter.recycler

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.iyeongjun.ocean_auction.R
import com.example.iyeongjun.ocean_auction.api.model.mofModel.Item
import com.example.iyeongjun.ocean_auction.api.model.mofModel.MofModel
import com.example.iyeongjun.ocean_auction.ex.distinctFish
import com.example.iyeongjun.ocean_auction.ex.makePair
import com.example.iyeongjun.ocean_auction.single.dataSingleton
import com.example.iyeongjun.ocean_auction.ui.activities.DetailActivity
import com.example.iyeongjun.ocean_auction.ui.activities.SelectActivity
import org.jetbrains.anko.startActivity

class SelectRecyclerAdapterFish( item : MofModel, val context: Context) : RecyclerView.Adapter<SelectFishViewHolder>() {
    val item = item.response.body.items.item

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectFishViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_fish , parent, false)
        return SelectFishViewHolder(view)
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: SelectFishViewHolder, position: Int) {
        val resName = "a"+item[position].mprcStdCode.toLowerCase()
        var res : Drawable? = null
        try {
            res = context.resources.getDrawable(context.resources.getIdentifier(resName, "drawable", context.packageName))
        }catch (e : Exception){
            res = context.resources.getDrawable(R.drawable.fish_default)
        }

        holder.item = item[position]
        holder.context = context
        holder.txtTitle.text = item[position].mprcStdCodeNm
        holder.txtSubTitle.text = item[position].mprcStdCode
        holder.imgFish.setImageDrawable(res!!)
    }

}
class SelectFishViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
    var item : Item? = null
    var context : Context? = null

    var txtTitle = itemView.findViewById<TextView>(R.id.txtFishTitle)
    var txtSubTitle = itemView.findViewById<TextView>(R.id.txtFishSubtitle)
    var imgFish = itemView.findViewById<ImageView>(R.id.imgFish)

    init { bind() }

    fun bind(){
        itemView.setOnClickListener {
            dataSingleton.resultItem = item!!
            context!!.startActivity<DetailActivity>()
        }
    }
}