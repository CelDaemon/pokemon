package net.voidgroup.pokemon

class Battle(private val challenger: Trainer, private val opponent: Trainer) {
    companion object {
        fun check(challenger: Pokemon, opponent: Pokemon): BattleResult {
            val challengerWins = challenger.strength == opponent.weakness
            val opponentWins = opponent.strength == challenger.weakness

            if (challengerWins && opponentWins || !challengerWins && !opponentWins) return BattleResult.DRAW
            return if (challengerWins) BattleResult.CHALLENGER else BattleResult.OPPONENT
        }
    }

    enum class BattleResult {
        CHALLENGER, OPPONENT, DRAW
    }

    private var previousResult: BattleResult? = null

    private var challengerPokeball: Pokeball? = null
    private var opponentPokeball: Pokeball? = null

    private fun shouldContinue() = challenger.belt.filterNot { it.pokemon.fainted }
        .isNotEmpty() && opponent.belt.filterNot { it.pokemon.fainted }.isNotEmpty()

    private fun resetTrainers() {
        for (pokeball in challenger.belt) pokeball.reset()
        for (pokeball in opponent.belt) pokeball.reset()
    }

    fun fight(): BattleResult {
        Arena.incrementBattles()
        var i = 0
        while (shouldContinue()) {
            i++
            printHeader("ROUND $i")
            playRound()
        }

        resetTrainers()

        if (challengerPokeball == null && opponentPokeball == null) return BattleResult.DRAW
        return if (challengerPokeball == null) BattleResult.OPPONENT else BattleResult.CHALLENGER
    }

    private fun playRound() {
        Arena.incrementRounds()
        val currentChallengerPokeball: Pokeball = challengerPokeball?.also {
            println("'${it.pokemon.displayName}' enters the round")
        } ?: challenger.getRandomPokeball().let { pokeball ->
            challengerPokeball = pokeball
            pokeball.open()
            pokeball
        }

        val currentOpponentPokeball = opponentPokeball?.also {
            println("'${it.pokemon.displayName}' enters the round")
        } ?: opponent.getRandomPokeball().let { pokeball ->
            opponentPokeball = pokeball
            pokeball.open()
            pokeball
        }


        val result = check(currentChallengerPokeball.pokemon, currentOpponentPokeball.pokemon)
        val (challengerFaint, opponentFaint) = when (result) {
            BattleResult.OPPONENT -> Pair(false, true)
            BattleResult.CHALLENGER -> Pair(true, false)
            BattleResult.DRAW -> when (previousResult) {
                BattleResult.CHALLENGER -> Pair(false, true)
                BattleResult.OPPONENT -> Pair(true, false)
                else -> Pair(true, true)
            }
        }
        previousResult = result
        if (challengerFaint) {
            currentChallengerPokeball.pokemon.faint()
            currentChallengerPokeball.close()
            challengerPokeball = null
        }
        if (opponentFaint) {
            currentOpponentPokeball.pokemon.faint()
            currentOpponentPokeball.close()
            opponentPokeball = null
        }

        println(
            when (result) {
                BattleResult.CHALLENGER -> "'${currentChallengerPokeball.pokemon.displayName}' ${
                    coloredString(
                        "WON", Color.BRIGHT_YELLOW
                    )
                } the round!"

                BattleResult.OPPONENT -> "'${currentChallengerPokeball.pokemon.displayName}' ${
                    coloredString(
                        "WON", Color.BRIGHT_YELLOW
                    )
                } the round!"

                BattleResult.DRAW -> "The round resulted in a ${coloredString("DRAW", Color.PURPLE)}"
            }
        )

    }


}