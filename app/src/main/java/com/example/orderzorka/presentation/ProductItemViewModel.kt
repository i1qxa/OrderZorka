package com.example.orderzorka.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.orderzorka.data.ProductRepositoryImpl
import com.example.orderzorka.domain.productItem.ProductItem
import kotlinx.coroutines.launch

class ProductItemViewModel(private val repository:ProductRepositoryImpl):ViewModel() {
    fun insertProduct(productItem:ProductItem) = viewModelScope.launch {
        repository.addProduct(productItem)
    }
    fun getProduct(productItemId:Int) = viewModelScope.launch {
        repository.getProductItem(productItemId)
    }
    fun editProduct(productItem: ProductItem) = viewModelScope.launch {
        repository.editProductItem(productItem)
    }
/*class ProductItemViewModelFactory(private val repository: ProductRepositoryImpl): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        TODO("Not yet implemented")
    }
}*/
}