package com.example.recipe.network.model

import com.example.recipe.domain.model.CategoryList
import com.example.recipe.domain.util.DtoMapper
import javax.inject.Inject

class CategoryDtoMapper @Inject constructor(
    private val mapper: CategoryItemDtoMapper
) : DtoMapper<CategoryDto, CategoryList> {
    override fun mapToDomainModel(dto: CategoryDto): CategoryList {
        with(dto) {
            return CategoryList(mapper.fromDtoListToModel(categories))
        }
    }

    override fun mapFromDomainModel(model: CategoryList): CategoryDto {
        with(model) {
            return CategoryDto(mapper.fromModelListToDto(categories))
        }
    }

    override fun fromDtoListToModel(dtoList: List<CategoryDto>?): List<CategoryList>? {
        return dtoList?.map { mapToDomainModel(it) }
    }

    override fun fromModelListToDto(modelList: List<CategoryList>?): List<CategoryDto>? {
        return modelList?.map { mapFromDomainModel(it) }
    }
}