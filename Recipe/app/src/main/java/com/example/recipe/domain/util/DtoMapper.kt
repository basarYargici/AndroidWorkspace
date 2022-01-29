package com.example.recipe.domain.util

interface DtoMapper<DTO, Model> {
    fun mapFromDTO(dto: DTO): Model
    fun mapToDTO(model: Model): DTO
}