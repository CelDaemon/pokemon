package net.voidgroup.pokemon

fun makeBelt(): MutableList<Pokeball> = MutableList(6) { i ->
    when (i % 3) {
        0 -> Pokeball(Charmander("Charmander ${1 + i / 3}"))
        1 -> Pokeball(Squirtle("Squirtle ${1 + i / 3}"))
        2 -> Pokeball(Bulbasaur("Bulbasaur ${1 + i / 3}"))
        else -> throw RuntimeException()
    }
}

fun main() {
    do {
        val challengerName = Input.readName("Enter the name for the challenger")
        val challenger = Trainer(challengerName, makeBelt())
        val opponentName = Input.readName("Enter the name for the opponent")
        val opponent = Trainer(opponentName, makeBelt())

        Battle(challenger, opponent).start()

    } while (Input.readBoolean("Do you want to restart?"))
}

