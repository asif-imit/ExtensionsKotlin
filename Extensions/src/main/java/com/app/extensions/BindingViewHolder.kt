package com.app.extensions

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BindingViewHolder<BindType:ViewBinding>
    (internal val binding:BindType): RecyclerView.ViewHolder(binding.root) {

    protected val context: Context =binding.root.context

    abstract fun bind()
}