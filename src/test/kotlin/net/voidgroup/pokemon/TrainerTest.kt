package net.voidgroup.pokemon

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class TrainerTest {
    private lateinit var trainer: Trainer
    @BeforeEach
    fun setupTrainer() {
        trainer = Trainer("Test Trainer", mutableListOf(Pokeball(Charmander("Test Charmander"))))
    }
    @Test
    fun `Throwing a pokeball removes it from the belt`() {
        trainer.throwBall()
        assertEquals(0, trainer.belt.size)
    }
    @Test
    fun `Throwing a pokeball when the belt is empty returns null`() {
        trainer.throwBall()
        assertNull(trainer.throwBall())
    }
}