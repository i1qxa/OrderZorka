package com.example.orderzorka.presentation.group

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.orderzorka.R
import com.example.orderzorka.domain.productItem.GroupItem

class GroupItemListAdapter:ListAdapter<GroupItem, GroupItemViewHolder>(GroupItemDiffCallback()) {
    var onGroupItemClickListener: ((GroupItem) -> Unit)?=null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupItemViewHolder {
        val layout = R.layout.group_product_layout
        val view = LayoutInflater.from(parent.context).inflate(layout,parent,false)
        return GroupItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: GroupItemViewHolder, position: Int) {
        val groupItem = getItem(position)
        holder.view.setOnClickListener {
            onGroupItemClickListener?.invoke(groupItem)
        }
        holder.tvRvGroupName.text = groupItem.name
    }
}