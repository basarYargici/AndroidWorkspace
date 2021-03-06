package com.example.recipe.domain.util

interface DtoMapper<DTO, Model> {
    fun mapToDomainModel(dto: DTO): Model
    fun mapFromDomainModel(model: Model): DTO
    fun fromDtoListToModel(dtoList: List<DTO>?): List<Model>?
    fun fromModelListToDto(modelList: List<Model>?): List<DTO>?
}