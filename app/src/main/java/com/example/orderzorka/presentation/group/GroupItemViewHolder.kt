package com.example.orderzorka.presentation.group

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.orderzorka.R

class GroupItemViewHolder(val view:View):RecyclerView.ViewHolder(view) {
    val tvRvGroupName = view.findViewById<TextView>(R.id.tvRvGroupName)
}