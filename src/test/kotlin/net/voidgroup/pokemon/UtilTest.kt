package net.voidgroup.pokemon

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

class UtilTest {

    @Test
    fun `Prompt for restarting defaults to no`() {
        assertEquals(handleBooleanResponse(""), false)
    }

    @Test
    fun `Various aliases for yes can be used in boolean response handler`() {
        for (input in listOf("y", "yes", "true", "Y", "yEs", "tRUe")) {
            assertEquals(true, handleBooleanResponse(input), "Return value was incorrect with input: '${input}'")
        }
    }

    @Test
    fun `Various aliases for no can be used in boolean response handler`() {
        for (input in listOf("n", "no", "false", "N", "nO", "fALsE")) {
            assertEquals(false, handleBooleanResponse(input), "Return value was incorrect with input: '${input}'")
        }
    }

    @Test
    fun `Invalid input in boolean response handler returns null`() {
        assertNull(handleBooleanResponse("meow"))
    }

    @Test
    fun `Input is trimmed in boolean response handler`() {
        assertEquals(true, handleBooleanResponse("  y  "))
    }

    @Test
    fun `Input is trimmed in string response handler`() {
        assertEquals("boo", handleStringResponse("  boo  "))
    }

    @Test
    fun `A blank input in the string response handler returns null`() {
        assertNull(handleStringResponse("  "))
    }

}