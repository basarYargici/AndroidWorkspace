package com.example.recipe.network.model.recipe

import com.example.recipe.domain.model.RecipeDetail
import com.example.recipe.domain.util.DtoMapper

class RecipeDetailDtoMapper : DtoMapper<RecipeDetailDto, RecipeDetail> {
    override fun mapToDomainModel(dto: RecipeDetailDto): RecipeDetail {
        with(dto) {
            return RecipeDetail(
                id, sourceUrl, imageUrl, publisher, ingredients, title, socialUrl, publishedId
            )
        }
    }

    override fun mapFromDomainModel(model: RecipeDetail): RecipeDetailDto {
        with(model) {
            return RecipeDetailDto(
                id, sourceUrl, imageUrl, publisher, ingredients, title, socialUrl, publishedId
            )
        }
    }

    override fun fromDtoListToModel(dtoList: List<RecipeDetailDto>?): List<RecipeDetail>? {
        return dtoList?.map { mapToDomainModel(it) }
    }

    override fun fromModelListToDto(modelList: List<RecipeDetail>?): List<RecipeDetailDto>? {
        return modelList?.map { mapFromDomainModel(it) }
    }
}