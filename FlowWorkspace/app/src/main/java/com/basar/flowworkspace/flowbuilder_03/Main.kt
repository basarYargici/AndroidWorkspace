package com.basar.flowworkspace.flowbuilder_03

import com.basar.flowworkspace.*
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    exampleOf("flowOf")

    val filmsFlow = flowOf(episodeI, episodeII, episodeIII)
    filmsFlow.collect { film -> log(film) }

    exampleOf("asFlow")
    val filmsList = listOf(episodeI, episodeII, episodeIII)
    filmsList.asFlow().collect { film -> log(film) }

}