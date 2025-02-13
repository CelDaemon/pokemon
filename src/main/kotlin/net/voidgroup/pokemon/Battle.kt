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
        CHALLENGER,
        OPPONENT,
        DRAW
    }

    private var previousResult: BattleResult? = null

    private var challengerActive: Pair<Pokeball, Pokemon>? = null
    private var opponentActive: Pair<Pokeball, Pokemon>? = null

    private fun shouldContinue() =
        (challengerActive != null || challenger.belt.filterNot { it.pokemon?.fainted ?: true }
            .isNotEmpty()) && (opponentActive != null || opponent.belt.filterNot { it.pokemon?.fainted ?: true }
            .isNotEmpty())

    fun fight(): BattleResult {
        Arena.incrementBattles()
        for (pokeball in challenger.belt) pokeball.pokemon?.fainted = false
        for (pokeball in opponent.belt) pokeball.pokemon?.fainted = false
        var i = 0
        while (shouldContinue()) {
            i++
            printHeader("ROUND $i")
            playRound()
        }
        if (challengerActive == null && opponentActive == null) return BattleResult.DRAW
        return if (challengerActive == null) BattleResult.OPPONENT else BattleResult.CHALLENGER
    }

    private fun playRound() {
        Arena.incrementRounds()
        val currentChallengerActive: Pair<Pokeball, Pokemon> = challengerActive?.also {
            println("'${it.second.displayName}' enters the round")
        } ?: challenger.belt.filterNot { it.pokemon?.fainted ?: true }.random().let { pokeball ->
            Pair(pokeball, pokeball.open()).also { challengerActive = it }
        }
        val currentOpponentActive = opponentActive?.also {
            println("'${it.second.displayName}' enters the round")
        } ?: opponent.belt.filterNot { it.pokemon?.fainted ?: true }.random().let { pokeball ->
            Pair(pokeball, pokeball.open()).also { opponentActive = it }
        }


        val result = check(currentChallengerActive.second, currentOpponentActive.second)
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
            currentChallengerActive.second.faint()
            currentChallengerActive.first.close(currentChallengerActive.second)
            challengerActive = null
        }
        if (opponentFaint) {
            currentOpponentActive.second.faint()
            currentOpponentActive.first.close(currentOpponentActive.second)
            opponentActive = null
        }

        println(
            when (result) {
                BattleResult.CHALLENGER -> "'${currentChallengerActive.second.displayName}' ${
                    coloredString(
                        "WON",
                        Color.BRIGHT_YELLOW
                    )
                } the round!"

                BattleResult.OPPONENT -> "'${currentChallengerActive.second.displayName}' ${
                    coloredString(
                        "WON",
                        Color.BRIGHT_YELLOW
                    )
                } the round!"

                BattleResult.DRAW -> "The round resulted in a ${coloredString("DRAW", Color.PURPLE)}"
            }
        )

    }


}