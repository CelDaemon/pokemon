package net.voidgroup.pokemon

object Arena {
    var roundCount = 0
        private set
    var battleCount = 0
        private set

    fun incrementRounds() = roundCount++
    fun incrementBattles() = battleCount++

    fun fight(challenger: Trainer, opponent: Trainer) {
        val result = Battle(challenger, opponent).fight()
        printHeader("RESULT")
        println(
            when (result) {
                Battle.BattleResult.CHALLENGER -> "$CHALLENGER_COLOR${challenger.displayName} ${Color.BRIGHT_YELLOW}WON${Color.RESET} the battle!"
                Battle.BattleResult.OPPONENT -> "$OPPONENT_COLOR${opponent.displayName} ${Color.BRIGHT_YELLOW}WON${Color.RESET} the battle!"
                Battle.BattleResult.DRAW -> "The battle resulted in a ${Color.PURPLE}DRAW${Color.RESET}"
            }
        )
    }
}