package net.voidgroup.pokemon

import net.voidgroup.pokemon.type.Charmander
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith

class TrainerTest {
    private lateinit var trainer: Trainer

    @BeforeEach
    fun setupTrainer() {
        trainer = Trainer("Test Trainer", Color.PURPLE)
        trainer.addPokeballs(listOf(Pokeball(Charmander("Test Charmander", trainer))))
    }

    @Test
    fun `Adding more than 6 pokeballs causes an exception`() {
        assertFailsWith<UnsupportedOperationException> {
            trainer.addPokeballs(
                listOf(
                    Pokeball(Charmander("Test Charmander", trainer)),
                    Pokeball(Charmander("Test Charmander", trainer)),
                    Pokeball(Charmander("Test Charmander", trainer)),
                    Pokeball(Charmander("Test Charmander", trainer)),
                    Pokeball(Charmander("Test Charmander", trainer)),
                    Pokeball(Charmander("Test Charmander", trainer))
                )
            )
        }
    }
}