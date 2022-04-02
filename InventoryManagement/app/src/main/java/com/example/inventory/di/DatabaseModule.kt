package com.example.inventory.di

import android.content.Context
import androidx.room.Room
import com.example.inventory.data.ItemDao
import com.example.inventory.data.ItemDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    fun provideItemDao(appDatabase: ItemDatabase): ItemDao {
        return appDatabase.itemDao()
    }

    @Provides
    @Singleton
    fun provideItemDatabase(@ApplicationContext appContext: Context): ItemDatabase {
        return Room.databaseBuilder(
            appContext.applicationContext,
            ItemDatabase::class.java,
            "item_database"
        ).build()
    }
}