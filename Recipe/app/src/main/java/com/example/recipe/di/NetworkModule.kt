package com.example.recipe.di

import com.example.recipe.network.RecipeService
import com.example.recipe.network.model.category.CategoryDtoMapper
import com.example.recipe.network.model.recipe.RecipeDetailDtoMapper
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideRecipeMapper(): RecipeDetailDtoMapper {
        return RecipeDetailDtoMapper()
    }

    @Singleton
    @Provides
    fun provideCategoryMapper(): CategoryDtoMapper {
        return CategoryDtoMapper()
    }

    @Singleton
    @Provides
    fun provideRecipeService(): RecipeService {
        return Retrofit.Builder()
            .baseUrl("https://recipesapi.herokuapp.com/api/v2/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(RecipeService::class.java)
    }
}