package com.example.orderzorka.presentation.group

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.orderzorka.data.GroupItemRepositoryImpl
import com.example.orderzorka.domain.productItem.GroupItem
import kotlinx.coroutines.launch

class GroupItemViewModel(private val repository: GroupItemRepositoryImpl):ViewModel() {
    val allGroups:LiveData<List<GroupItem>> = repository.allGroups.asLiveData()
    fun insertGroupItem(groupItem:GroupItem) = viewModelScope.launch {
        repository.addGroupItem(groupItem)
    }
    fun editGroupItem(groupItem:GroupItem) = viewModelScope.launch {
        repository.editGroupItem(groupItem)
    }
}