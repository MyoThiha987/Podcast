package com.mth.shared.views.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {

//    init {
//        itemView.setOnClickListener {
//            mData?.let {
//                onClickItem(it)
//            }
//        }
//    }
    var mData : T? = null
    abstract fun bindData(data : T)
    //abstract fun onClickItem(data : T)
}