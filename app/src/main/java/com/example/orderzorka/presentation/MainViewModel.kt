package com.example.orderzorka.presentation

import androidx.lifecycle.*
import com.example.orderzorka.data.ProductRepositoryImpl
import com.example.orderzorka.domain.productItem.ProductItem
import kotlinx.coroutines.launch

class MainViewModel(private val repository:ProductRepositoryImpl):ViewModel() {
    val allProducts: LiveData<List<ProductItem>> = repository.allProducts.asLiveData()
    fun insertProduct(productItem:ProductItem) = viewModelScope.launch {
        repository.addProduct(productItem)
    }

}
class MainViewModelFactory(private val repository: ProductRepositoryImpl) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}