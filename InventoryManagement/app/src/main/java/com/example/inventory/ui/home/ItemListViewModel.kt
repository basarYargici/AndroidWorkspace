package com.example.inventory.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.inventory.data.Item
import com.example.inventory.domain.repository.ItemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemListViewModel @Inject constructor(private val itemRepository: ItemRepository) : ViewModel() {

    var items = ArrayList<Item>()
    fun getAllItems() {
        viewModelScope.launch(Dispatchers.IO) {
            itemRepository.getAllItems().collect {
                Log.d("ALL", "getAllItems: $it")
                items = ArrayList(it)
            }
        }
    }
}