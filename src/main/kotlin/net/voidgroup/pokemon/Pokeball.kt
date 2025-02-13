package net.voidgroup.pokemon

data class Pokeball(var pokemon: Pokemon?) {

    fun open(): Pokemon {
        val currentPokemon = pokemon ?: throw IllegalStateException("Pokeball is empty")
        pokemon = null
        println("'${currentPokemon.displayName}' emerged!")
        currentPokemon.battleCry()
        return currentPokemon
    }

    fun close(newPokemon: Pokemon) {
        if (pokemon != null) throw IllegalStateException("Pokeball is not empty")
        pokemon = newPokemon
        println("'${newPokemon.displayName}' returned to the pokeball")
    }
}
