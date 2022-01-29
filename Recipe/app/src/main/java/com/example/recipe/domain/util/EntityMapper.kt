package com.example.recipe.domain.util

interface EntityMapper<Entity, Model> {
    fun mapToDomainModel(entity: Entity): Model
    fun mapFromDomainModel(model: Model): Entity
}