package com.example.recipe.di

import com.example.recipe.network.RecipeService
import com.example.recipe.network.model.category.CategoryDtoMapper
import com.example.recipe.network.model.recipe.RecipeDetailDtoMapper
import com.example.recipe.repository.RecipeRepository
import com.example.recipe.repository.RecipeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideRecipeRepository(
        recipeService: RecipeService,
        recipeDetailMapper: RecipeDetailDtoMapper,
        categoryMapper: CategoryDtoMapper
    ): RecipeRepository {
        return RecipeRepositoryImpl(
            recipeService,
            recipeDetailMapper,
            categoryMapper
        )
    }
}