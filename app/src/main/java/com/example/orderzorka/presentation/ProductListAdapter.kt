package com.example.orderzorka.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.orderzorka.R
import com.example.orderzorka.domain.productItem.ProductItem
import java.lang.RuntimeException

class ProductListAdapter:androidx.recyclerview.widget.ListAdapter<ProductItem,ProductItemViewHolder>(ProductItemDiffCallback()) {
    var onProductItemClickListener: ((ProductItem) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductItemViewHolder {
        val layout = when(viewType){
            ITEM_IS_GROUP -> R.layout.group_product_item_layout
            ITEM_IS_PRODUCT -> R.layout.product_item_layout
            else -> throw RuntimeException("Unknown ViewType $viewType")
        }
        val view =LayoutInflater.from(parent.context).inflate(layout, parent,false)
        return ProductItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductItemViewHolder, position: Int) {
        val productItem =getItem(position)
        holder.view.setOnClickListener {
            onProductItemClickListener?.invoke(productItem)
        }
        if(getItem(position).groupProductId !=2) {
            holder.tvName.text = productItem.productName
            holder.tvUnit.text = productItem.productId.toString()
        }
        else holder.tvName.text = productItem.productName
    }

    override fun getItemViewType(position: Int): Int {
        return if (getItem(position).groupProductId == 2) ITEM_IS_GROUP else ITEM_IS_PRODUCT
    }
    companion object{
        const val MAX_POOL_SIZE =20
        const val ITEM_IS_PRODUCT = 1
        const val ITEM_IS_GROUP = 2
    }
}