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

    override fun fromDtoListToModel(dtoList: List<RecipeDto>?): List<Recipe>? {
        return dtoList?.map { mapToDomainModel(it) }
    }

    override fun fromModelListToDto(modelList: List<Recipe>?): List<RecipeDto>? {
        return modelList?.map { mapFromDomainModel(it) }
    }
}