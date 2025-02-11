package net.voidgroup.pokemon

data class Pokeball(private val charmander: Charmander) {
    private var open = false

    fun open(): Charmander {
        if(open) throw IllegalStateException("Pokeball is already open")
        open = true
        return charmander
    }
    fun close() {
        if(!open) throw IllegalStateException("Pokeball is already closed")
        open = false
    }

}
