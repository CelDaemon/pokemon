package net.voidgroup.pokemon

import org.junit.jupiter.api.Test
import kotlin.test.*

class InputTest {

    @Test
    fun `Prompt for restarting defaults to no`() {
        assertEquals(Input.handleBooleanResponse(""), false)
    }

    @Test
    fun `Various aliases for yes can be used in boolean response handler`() {
        for (input in listOf("y", "yes", "true", "Y", "yEs", "tRUe")) {
            assertEquals(true, Input.handleBooleanResponse(input), "Return value was incorrect with input: '${input}'")
        }
    }

    @Test
    fun `Various aliases for no can be used in boolean response handler`() {
        for (input in listOf("n", "no", "false", "N", "nO", "fALsE")) {
            assertEquals(false, Input.handleBooleanResponse(input), "Return value was incorrect with input: '${input}'")
        }
    }

    @Test
    fun `Invalid input in boolean response handler returns null`() {
        assertNull(Input.handleBooleanResponse("meow"))
    }

    @Test
    fun `Input is trimmed in boolean response handler`() {
        assertEquals(true, Input.handleBooleanResponse("  y  "))
    }

    @Test
    fun `Input is trimmed in string response handler`() {
        assertEquals("boo", Input.handleStringResponse("  boo  "))
    }

    @Test
    fun `A blank input in the string response handler returns null`() {
        assertNull(Input.handleStringResponse("  "))
    }

}