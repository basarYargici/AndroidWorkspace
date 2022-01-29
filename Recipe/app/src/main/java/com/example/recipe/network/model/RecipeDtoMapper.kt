package com.example.recipe.network.model

import com.example.recipe.domain.model.Recipe
import com.example.recipe.domain.util.DtoMapper

class RecipeDtoMapper : DtoMapper<RecipeDto, Recipe> {
    override fun mapToDomainModel(dto: RecipeDto): Recipe {
        with(dto) {
            return Recipe(
                id, sourceUrl, imageUrl, publisher, ingredients, title, socialUrl, publishedId
            )
        }
    }

    override fun mapFromDomainModel(model: Recipe): RecipeDto {
        with(model) {
            return RecipeDto(
                id, sourceUrl, imageUrl, publisher, ingredients, title, socialUrl, publishedId
            )
        }
    }

    fun fromDTOList(initial: List<RecipeDto>): List<Recipe> {
        return initial.map { mapToDomainModel(it) }
    }

    fun toDTOList(initial: List<Recipe>): List<RecipeDto> {
        return initial.map { mapFromDomainModel(it) }
    }
}