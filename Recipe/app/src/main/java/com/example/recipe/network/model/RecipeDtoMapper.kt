package com.example.recipe.network.model

import com.example.recipe.domain.model.Recipe
import com.example.recipe.domain.util.DtoMapper

class RecipeDtoMapper : DtoMapper<RecipeDto, Recipe> {
    override fun mapFromDTO(dto: RecipeDto): Recipe {
        with(dto) {
            return Recipe(
                id, sourceUrl, imageUrl, publisher, ingredients, title, socialUrl, publishedId
            )
        }
    }

    override fun mapToDTO(model: Recipe): RecipeDto {
        with(model) {
            return RecipeDto(
                id, sourceUrl, imageUrl, publisher, ingredients, title, socialUrl, publishedId
            )
        }
    }

    fun fromDTOList(initial: List<RecipeDto>): List<Recipe> {
        return initial.map { mapFromDTO(it) }
    }

    fun toDTOList(initial: List<Recipe>): List<RecipeDto> {
        return initial.map { mapToDTO(it) }
    }
}