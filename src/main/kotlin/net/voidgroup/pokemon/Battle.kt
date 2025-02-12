package net.voidgroup.pokemon

class Battle(private val challenger: Trainer, private val opponent: Trainer) {
    fun start() {
        while(challenger.belt.isNotEmpty() || opponent.belt.isNotEmpty()) {
            val challengerPokeball = challenger.throwBall()?.also {
                println("[${challenger.name}]: Go, ${it.pokemon.nickname}!")
            }
            val challengerPokemon = challengerPokeball?.open()

            challengerPokemon?.battleCry()

            val opponentPokeball = opponent.throwBall()?.also {
                println("[${opponent.name}]: Go, ${it.pokemon.nickname}!")
            }
            val opponentPokemon = opponentPokeball?.open()

            opponentPokemon?.battleCry()

            challengerPokeball?.close()
            opponentPokeball?.close()
        }
    }
}