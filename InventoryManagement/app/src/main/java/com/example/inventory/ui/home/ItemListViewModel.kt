package com.example.inventory.ui.home

import androidx.lifecycle.ViewModel
import com.example.inventory.data.Item
import com.example.inventory.domain.repository.ItemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class ItemListViewModel @Inject constructor(private val itemRepository: ItemRepository) : ViewModel() {
    suspend fun getAllItems(): Flow<List<Item>> {
        return itemRepository.getAllItems()
    }
}