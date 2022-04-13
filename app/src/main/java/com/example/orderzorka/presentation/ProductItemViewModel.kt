package com.example.orderzorka.presentation

import androidx.lifecycle.*
import com.example.orderzorka.data.ProductRepositoryImpl
import com.example.orderzorka.domain.productItem.ProductItem
import kotlinx.coroutines.launch

class ProductItemViewModel(private val repository:ProductRepositoryImpl):ViewModel() {
    private var _productItem = MutableLiveData<ProductItem>()
    val productItem:LiveData<ProductItem>
        get() = _productItem
    private var _shouldCloseScreen = MutableLiveData<Unit>()
    val shouldCloseScreen:LiveData<Unit>
        get() =_shouldCloseScreen

    fun insertProduct(productItem:ProductItem) = viewModelScope.launch {
        repository.addProduct(productItem)
        finishWork()
    }
    fun getProduct(productItemId:Int) = viewModelScope.launch {
        _productItem.value = repository.getProductItem(productItemId)
    }
    fun editProduct(productItem: ProductItem) = viewModelScope.launch {
        repository.editProductItem(productItem)
        finishWork()
    }
    fun finishWork(){
        _shouldCloseScreen.value = Unit
    }
class ProductItemViewModelFactory(private val repository: ProductRepositoryImpl): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
}