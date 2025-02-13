package net.voidgroup.pokemon

val CHALLENGER_COLOR = Color.BRIGHT_BLUE
val OPPONENT_COLOR = Color.BRIGHT_RED

class Trainer(private val name: String, val color: Color) {
    val belt: MutableList<Pokeball> = mutableListOf()

    val displayName: String
        get() = "$color$name${Color.RESET}"

    fun addPokeballs(pokeballs: Collection<Pokeball>) {
        if (belt.size + pokeballs.size > 6) throw UnsupportedOperationException("The belt cannot contain more than 6 pokeballs")
        for (pokeball in pokeballs) pokeball.pokemon?.owner = this
        belt.addAll(pokeballs)
    }
}
