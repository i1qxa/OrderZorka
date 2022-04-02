package com.example.orderzorka.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.orderzorka.domain.productItem.ProductItem

class ProductItemDiffCallback:DiffUtil.ItemCallback<ProductItem>() {
    override fun areItemsTheSame(oldItem: ProductItem, newItem: ProductItem): Boolean {
        return oldItem.productId == newItem.productId
    }

    override fun areContentsTheSame(oldItem: ProductItem, newItem: ProductItem): Boolean {
        return oldItem == newItem
    }
}