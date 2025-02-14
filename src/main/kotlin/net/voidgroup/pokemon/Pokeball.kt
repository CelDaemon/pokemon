package net.voidgroup.pokemon

data class Pokeball(val pokemon: Pokemon) {
    private var isOpen = false
    fun open() {
        if (isOpen) throw IllegalStateException("Pokeball is already open")
        isOpen = true
        println("'${pokemon.displayName}' emerged!")
        pokemon.battleCry()
    }

    fun close() {
        if (!isOpen) throw IllegalStateException("Pokeball is already closed")
        isOpen = false
        println("'${pokemon.displayName}' returned to the pokeball")
    }
    fun reset() {
        isOpen = false
        pokemon.reset()
    }
}
