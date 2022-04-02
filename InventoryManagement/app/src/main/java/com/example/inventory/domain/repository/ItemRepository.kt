package com.example.inventory.domain.repository

import com.example.inventory.data.Item
import com.example.inventory.data.ItemDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class ItemRepository @Inject constructor(private val itemDao: ItemDao) {

    fun addItem(item: Item): Flow<Boolean> {
        itemDao.addItem(item)
        return flowOf(true)
    }

    fun updateItem(item: Item) {
        return itemDao.updateItem(item)
    }

    fun deleteItem(item: Item) {
        return itemDao.deleteItem(item)
    }

    suspend fun getAllItems(): Flow<List<Item>> {
        return itemDao.getAllItems()
    }

    suspend fun getItem(id: Int): Flow<Item> {
        return itemDao.getItem(id)
    }
}