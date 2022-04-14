package com.example.orderzorka.presentation

import androidx.lifecycle.*
import com.example.orderzorka.data.ProductRepositoryImpl
import com.example.orderzorka.domain.productItem.ProductItem
import kotlinx.coroutines.launch
import java.lang.Exception

class ProductItemViewModel(private val repository:ProductRepositoryImpl):ViewModel() {
    private var _productItem = MutableLiveData<ProductItem>()
    val productItem:LiveData<ProductItem>
        get() = _productItem
    private var _shouldCloseScreen = MutableLiveData<Unit>()
    val shouldCloseScreen:LiveData<Unit>
        get() =_shouldCloseScreen

    private var _errorInputName = MutableLiveData<Boolean>()
    val errorInputName:LiveData<Boolean>
        get() = _errorInputName

    private var _errorInputGroup = MutableLiveData<Boolean>()
    val errorInputGroup:LiveData<Boolean>
        get() = _errorInputGroup

    private var _errorInputUnit = MutableLiveData<Boolean>()
    val errorInputUnit:LiveData<Boolean>
        get() = _errorInputUnit

    private fun parseName(inputName:String):String{
        return inputName?.trim() ?: ""
    }
    private fun parseGroup(inputGroup:String):Int{
        return try {
            inputGroup?.trim()?.toInt() ?: 0
        }
        catch (e:Exception){
            0
        }
    }
    private fun parseUnit(inputUnit:String):Int{
        return try {
            inputUnit?.trim()?.toInt() ?: 0
        }
        catch (e:Exception){
            0
        }
    }
    fun validateInput(name:String, group:String, unit:String):Boolean{
        var result = true
        if (parseName(name) == ""){
            _errorInputName.value = true
            result = false
        }
        if (parseGroup(group)<=0){
            _errorInputGroup.value = true
            result = false
        }
        if (parseUnit(unit)<=0){
            _errorInputUnit.value = true
            result = false
        }
        return result
    }
    fun resetErrorInputName(){
        _errorInputName.value = false
       }
    fun resetErrorInputGroup(){
        _errorInputGroup.value = false
    }
    fun resetErrorInputUnit(){
        _errorInputUnit.value = false
    }

    fun insertProduct(name: String,group: String,unit: String) = viewModelScope.launch {
        if (validateInput(name, group, unit)) {
            val newProduct = ProductItem(0, parseName(name), parseUnit(unit), parseGroup(group))
            repository.addProduct(newProduct)
            finishWork()
        }
    }
    fun getProduct(productItemId:Int) = viewModelScope.launch {
        TODO("Реализовать получение одного эллемента из бд")
        //_productItem.value = repository.getProductItem(productItemId)
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