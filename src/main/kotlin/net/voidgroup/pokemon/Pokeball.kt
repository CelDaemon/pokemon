package net.voidgroup.pokemon

data class Pokeball(val pokemon: Pokemon) {
    private var isOpen = false
    fun open() {
        if(isOpen) throw IllegalStateException("Pokeball is empty")
        isOpen = true
        println("'${pokemon.displayName}' emerged!")
        pokemon.battleCry()
    }

    fun close() {
        if(!isOpen) throw IllegalStateException("Pokeball is not empty")
        isOpen = false
        println("'${pokemon.displayName}' returned to the pokeball")
    }
}
