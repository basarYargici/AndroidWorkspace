package com.example.recipe.di

import com.example.recipe.network.RecipeService
import com.example.recipe.network.model.CategoryDtoMapper
import com.example.recipe.network.model.CategoryItemDtoMapper
import com.example.recipe.network.model.RecipeDtoMapper
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
    fun provideRecipeMapper(): RecipeDtoMapper {
        return RecipeDtoMapper()
    }

    @Singleton
    @Provides
    fun provideCategoryItemMapper(): CategoryItemDtoMapper {
        return CategoryItemDtoMapper()
    }

    @Singleton
    @Provides
    fun provideCategoryDtoMapper(
        categoryItemDtoMapper: CategoryItemDtoMapper
    ): CategoryDtoMapper {
        return CategoryDtoMapper(categoryItemDtoMapper)
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