package net.voidgroup.pokemon

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class BattleTest {

    @Test
    fun `Pokemon that do not have each other's weakness cause a draw`() {
        assertEquals(Battle.BattleResult.DRAW, Battle.check(Squirtle("Challenger"), Squirtle("Opponent")))
    }
    @Test
    fun `Pokemon that have each other's weaknesses should cause a draw`() {
        class DrawPokemon(nickname: String) : Pokemon(nickname) {
            override val strength: Element
                get() = Element.WATER
            override val weakness: Element
                get() = Element.FIRE
            override val name: String
                get() = "Draw Tester"

        }
        assertEquals(Battle.BattleResult.DRAW, Battle.check(Charmander("Challenger"), DrawPokemon("Opponent")))
    }

    @Test
    fun `Challenger with the same strength as the opponent's weakness wins`() {
        assertEquals(Battle.BattleResult.CHALLENGER, Battle.check(Charmander("Challenger"), Bulbasaur("Opponent")))
    }

    @Test
    fun `Opponent with the same strength as the challenger's weakness wins`() {
        assertEquals(Battle.BattleResult.OPPONENT, Battle.check(Charmander("Challenger"), Squirtle("Opponent")))
    }
}