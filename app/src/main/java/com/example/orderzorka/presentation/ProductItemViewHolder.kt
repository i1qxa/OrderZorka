package com.example.orderzorka.presentation

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.orderzorka.R

class ProductItemViewHolder(val view:View):RecyclerView.ViewHolder(view) {
    val tvName = view.findViewById<TextView>(R.id.tvRvGroupName)
    val tvUnit = view.findViewById<TextView>(R.id.tv_unit)
}