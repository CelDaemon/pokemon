package net.voidgroup.pokemon

class Trainer(val name: String, belt: MutableList<Pokeball>) {
    companion object {
        private const val MAX_SIZE = 6
    }
    init {
        if(belt.size > MAX_SIZE) throw IllegalArgumentException("The belt cannot be bigger than $MAX_SIZE pokeballs")
    }
    private val _belt: MutableList<Pokeball> = belt

    val belt: List<Pokeball> = _belt

    fun throwBall(): Pokeball? = _belt.removeFirstOrNull()
}
