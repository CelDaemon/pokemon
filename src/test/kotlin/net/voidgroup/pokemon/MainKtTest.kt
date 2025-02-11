package net.voidgroup.pokemon

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test

class MainKtTest {

    @Test
    fun `Don't accept blank pokemon nicknames`() {
        assertFalse(validatePokemonNickname(" "))
    }

    @Test
    fun `Trim accepted pokemon nicknames`() {
        assertEquals("foo bar", sanitizePokemonNickname("   foo bar  "))
    }

}