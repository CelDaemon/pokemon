package net.voidgroup.pokemon

import net.voidgroup.pokemon.Arena.battleCount
import net.voidgroup.pokemon.Arena.roundCount

fun addPokeballs(trainer: Trainer) {
    trainer.addPokeballs(List(6) { i ->
        Pokeball(
            when (i % 3) {
                0 -> Charmander("Charmander ${1 + i / 3}")
                1 -> Squirtle("Squirtle ${1 + i / 3}")
                2 -> Bulbasaur("Bulbasaur ${1 + i / 3}")
                else -> throw UnsupportedOperationException()
            }
        )
    })
}

fun main() {
    do {
        printHeader("SETUP")
        val challenger = Trainer(
            readName("Enter the name for the ${coloredString("challenger", Color.BRIGHT_BLUE)}"),
            Color.BRIGHT_BLUE
        )

        addPokeballs(challenger)
        val opponent = Trainer(
            readName("Enter the name for the ${coloredString("opponent", Color.BRIGHT_RED)}"),
            Color.BRIGHT_RED
        )
        addPokeballs(opponent)

        Arena.fight(challenger, opponent)

    } while (readBoolean("Do you want to restart?"))

    printHeader("STATS")

    println("Total battles: ${coloredString(battleCount.toString(), Color.BRIGHT_GREEN)}")
    println("Total rounds: ${coloredString(roundCount.toString(), Color.BRIGHT_GREEN)}")
}

