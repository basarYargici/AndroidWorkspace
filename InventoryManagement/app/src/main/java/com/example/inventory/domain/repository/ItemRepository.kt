package com.example.inventory.domain.repository

import com.example.inventory.data.Item
import com.example.inventory.data.ItemDao
import kotlinx.coroutines.flow.Flow

class ItemRepository(private val itemDao: ItemDao) {

    suspend fun addItem(item: Item): Flow<Boolean> {
        return itemDao.addItem(item)
    }

    suspend fun updateItem(id: Int, item: Item): Flow<Boolean> {
        return itemDao.updateItem(id, item)
    }

    suspend fun deleteItem(id: Int): Flow<Boolean> {
        return itemDao.deleteItem(id)
    }

    suspend fun getAllItems(): Flow<List<Item>> {
        return itemDao.getAllItems()
    }

    suspend fun getItem(id: Int): Flow<Item> {
        return itemDao.getItem(id)
    }
}