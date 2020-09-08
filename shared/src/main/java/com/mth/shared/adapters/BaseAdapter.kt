package com.mth.shared.adapters

import androidx.recyclerview.widget.RecyclerView
import com.mth.shared.views.viewholders.BaseViewHolder

abstract class BaseRecyclerAdapter<T: BaseViewHolder<W>,W> : RecyclerView.Adapter<T>() {
    var mData : MutableList<W> = mutableListOf()

    override fun onBindViewHolder(holder: T, position: Int) {
        holder.bindData(mData[position])
    }

    override fun getItemCount(): Int {
        return mData.count()
    }

    fun setNewData(data : MutableList<W>){
        mData = data
        notifyDataSetChanged()

    }

    fun appendData(data : MutableList<W>){
        mData.addAll(data)
        notifyDataSetChanged()
    }
}