package net.voidgroup.pokemon

import net.voidgroup.pokemon.type.Charmander
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith

class PokemonTest {
    private val trainer = Trainer("Test", Color.PURPLE)
    private lateinit var pokeball: Pokeball

    @BeforeEach
    fun setupPokeball() {
        pokeball = Pokeball(Charmander("Charmander", trainer))
    }

    @Test
    fun `Opening an already opened pokeball throws an exception`() {
        pokeball.open()
        assertFailsWith(IllegalStateException::class) {
            pokeball.open()
        }
    }

    @Test
    fun `Closing an already closed pokeball throws an exception`() {
        assertFailsWith(IllegalStateException::class) {
            pokeball.close()
        }
    }
}