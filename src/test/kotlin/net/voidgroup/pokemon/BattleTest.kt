package net.voidgroup.pokemon

import net.voidgroup.pokemon.type.Bulbasaur
import net.voidgroup.pokemon.type.Charmander
import net.voidgroup.pokemon.type.Squirtle
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class BattleTest {
    private val trainer = Trainer("Test", Color.PURPLE)

    @Test
    fun `Pokemon that do not have each other's weakness cause a draw`() {
        assertEquals(
            Battle.BattleResult.DRAW, Battle.check(Squirtle("Challenger", trainer), Squirtle("Opponent", trainer))
        )
    }

    @Test
    fun `Pokemon that have each other's weaknesses should cause a draw`() {
        class DrawPokemon(nickname: String, owner: Trainer) : Pokemon(nickname, owner) {
            override val strength: Element
                get() = Element.WATER
            override val weakness: Element
                get() = Element.FIRE
            override val name: String
                get() = "Draw Tester"

        }

        assertEquals(
            Battle.BattleResult.DRAW, Battle.check(Charmander("Challenger", trainer), DrawPokemon("Opponent", trainer))
        )
    }

    @Test
    fun `Challenger with the same strength as the opponent's weakness wins`() {
        assertEquals(
            Battle.BattleResult.CHALLENGER,
            Battle.check(Charmander("Challenger", trainer), Bulbasaur("Opponent", trainer))
        )
    }

    @Test
    fun `Opponent with the same strength as the challenger's weakness wins`() {
        assertEquals(
            Battle.BattleResult.OPPONENT, Battle.check(Charmander("Challenger", trainer), Squirtle("Opponent", trainer))
        )
    }
}