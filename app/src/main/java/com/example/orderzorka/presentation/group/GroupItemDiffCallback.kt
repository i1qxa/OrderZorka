package com.example.orderzorka.presentation.group

import androidx.recyclerview.widget.DiffUtil
import com.example.orderzorka.domain.productItem.GroupItem

class GroupItemDiffCallback:DiffUtil.ItemCallback<GroupItem>() {
    override fun areItemsTheSame(oldItem: GroupItem, newItem: GroupItem): Boolean {
        return oldItem.groupId == newItem.groupId
    }

    override fun areContentsTheSame(oldItem: GroupItem, newItem: GroupItem): Boolean {
        return oldItem == newItem
    }
}