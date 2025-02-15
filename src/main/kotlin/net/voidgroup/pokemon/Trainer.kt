package net.voidgroup.pokemon

class Trainer(private val name: String, val color: Color) {
    val belt: MutableList<Pokeball> = mutableListOf()

    val displayName: String
        get() = coloredString(name, color)

    fun addPokeballs(pokeballs: Collection<Pokeball>) {
        if (belt.size + pokeballs.size > 6) throw UnsupportedOperationException("The belt cannot contain more than 6 pokeballs")
        belt.addAll(pokeballs)
    }
    fun getRandomPokeball(): Pokeball = belt.filterNot { it.pokemon.fainted }.random()
}
