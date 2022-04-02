package com.example.inventory.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addItem(item: Item): Flow<Boolean>

    @Update
    suspend fun updateItem(id: Int, item: Item): Flow<Boolean>

    @Delete
    suspend fun deleteItem(id: Int): Flow<Boolean>

    @Query("SELECT * FROM item ORDER BY name ASC")
    suspend fun getAllItems(): Flow<List<Item>>

    @Query("SELECT * FROM item WHERE id = :id")
    suspend fun getItem(id: Int): Flow<Item>
}