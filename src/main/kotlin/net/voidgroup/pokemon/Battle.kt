package net.voidgroup.pokemon

class Battle(private val challenger: Trainer, private val opponent: Trainer) {
    fun start() {
        while(challenger.belt.isNotEmpty() || opponent.belt.isNotEmpty()) {
            val challengerPokeball = challenger.throwBall()
            val challengerPokemon = challengerPokeball?.open()

            challengerPokemon?.battleCry()

            val opponentPokeball = opponent.throwBall()
            val opponentPokemon = opponentPokeball?.open()

            opponentPokemon?.battleCry()

            challengerPokeball?.close()
            opponentPokeball?.close()
        }
    }
}