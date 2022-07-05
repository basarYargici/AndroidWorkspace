package com.basar.flowworkspace.simpleFlow_02

fun exampleOf(description: String, action: () -> Unit = {}) {
    println("\n--- Example of: $description ---")
    action()
}

fun log(message: String) = println("[${Thread.currentThread().name}] $message")

const val DELAY = 500L

const val episodeI = "The Phantom Menace"
const val episodeII = "Attack of the Clones"
const val theCloneWars = "The Clone Wars"
const val episodeIII = "Revenge of the Sith"
const val solo = "Solo: A Star Wars Story"
const val rogueOne = "Rogue One: A Star Wars Story"
const val episodeIV = "A New Hope"
const val episodeV = "The Empire Strikes Back"
const val episodeVI = "Return of the Jedi"
const val episodeVII = "The Force Awakens"
const val episodeVIII = "The Last Jedi"
const val episodeIX = "The Rise of Skywalker"

const val chewieSound = "Arwerwrw"
const val r2d2Sound = "Beep-bee-bee-boop-bee-doo-weep"
const val blasterSound = "Pew pew, pew pew"
const val saberSound = "Schvrmmmmmmm, schvrmmmmmmm!"

val characterNames = listOf("Luke Skywalker", "Han Solo", "Chewbacca")
val weaponNames = listOf("Light saber", "Heavy Blaster Pistol", "Bowcaster")

val midichlorianCounts = mapOf("Baby Yoda" to 15000, "Qui-Gon Jinn" to 10000, "Anakin Skywalker" to 20000)
const val CHOSEN_ONE_THRESHOLD = 19000

sealed class ForceUser {
    abstract var name: String
}

data class Padawan(override var name: String) : ForceUser()
data class Jedi(override var name: String) : ForceUser()
data class Sith(override var name: String) : ForceUser()
data class Ren(override var name: String) : ForceUser()

val forceUsers: List<ForceUser> = listOf(
    Padawan("Ahsoka Tano"),
    Padawan("Anakin Skywalker"),
    Jedi("Luke Skywalker"),
    Sith("Sidious"),
    Sith("Vader"),
    Padawan("Ezra Bridger"),
    Jedi("Obi-Wan Kenobi"),
    Jedi("Yoda"),
    Ren("Kylo"),
    Sith("Maul")
)
