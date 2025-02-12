package net.voidgroup.pokemon

data class Pokeball(val pokemon: Pokemon) {
    private var open = false

    fun open(): Pokemon {
        if(open) throw IllegalStateException("Pokeball is already open")
        open = true
        return pokemon
    }
    fun close() {
        if(!open) throw IllegalStateException("Pokeball is already closed")
        open = false
    }
}
