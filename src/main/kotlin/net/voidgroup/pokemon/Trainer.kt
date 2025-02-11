package net.voidgroup.pokemon

class Trainer(val name: String, belt: MutableList<Pokeball>) {
    companion object {
        private const val MAX_SIZE = 6
    }
    constructor(name: String) : this(name, MutableList(MAX_SIZE) { i -> Pokeball(Charmander("${name}'s Charmander $i")) })
    init {
        if(belt.size > MAX_SIZE) throw IllegalArgumentException("The belt cannot be bigger than $MAX_SIZE pokeballs")
    }
    private val _belt: MutableList<Pokeball> = belt

    val belt: List<Pokeball> = _belt

    fun throwBall(): Pokeball? {
        return _belt.removeFirstOrNull()
    }
}
