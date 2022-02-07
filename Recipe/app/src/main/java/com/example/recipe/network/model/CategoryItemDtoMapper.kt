package com.example.recipe.network.model

import com.example.recipe.domain.model.CategoryItem
import com.example.recipe.domain.util.DtoMapper

class CategoryItemDtoMapper : DtoMapper<CategoryItemDto, CategoryItem> {
    override fun mapToDomainModel(dto: CategoryItemDto): CategoryItem {
        with(dto) {
            return CategoryItem(imageUrl, title)
        }
    }

    override fun mapFromDomainModel(model: CategoryItem): CategoryItemDto {
        with(model) {
            return CategoryItemDto(imageUrl, title)
        }
    }

    override fun fromDtoListToModel(dtoList: List<CategoryItemDto>?): List<CategoryItem>? {
        return dtoList?.map { mapToDomainModel(it) }
    }

    override fun fromModelListToDto(modelList: List<CategoryItem>?): List<CategoryItemDto>? {
        return modelList?.map { mapFromDomainModel(it) }
    }
}