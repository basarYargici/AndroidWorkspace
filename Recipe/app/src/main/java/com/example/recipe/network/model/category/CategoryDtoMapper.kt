package com.example.recipe.network.model.category

import com.example.recipe.domain.model.Category
import com.example.recipe.domain.util.DtoMapper

class CategoryDtoMapper : DtoMapper<CategoryDto,Category> {
    override fun mapToDomainModel(dto: CategoryDto): Category {
        return Category(dto.imageUrl,dto.title)
    }

    override fun mapFromDomainModel(model: Category): CategoryDto {
        return CategoryDto(model.imageUrl,model.title)
    }

    override fun fromDtoListToModel(dtoList: List<CategoryDto>?): List<Category>? {
        return dtoList?.map { mapToDomainModel(it) }
    }

    override fun fromModelListToDto(modelList: List<Category>?): List<CategoryDto>? {
        return modelList?.map { mapFromDomainModel(it) }
    }
}