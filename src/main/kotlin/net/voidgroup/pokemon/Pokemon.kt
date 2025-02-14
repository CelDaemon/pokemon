package net.voidgroup.pokemon

abstract class Pokemon(private val nickname: String, private val owner: Trainer) {
    abstract val strength: Element
    abstract val weakness: Element
    abstract val name: String
    var fainted: Boolean = false
        private set
    val displayName
        get() = "${owner.color}$nickname${Color.RESET}"

    fun faint() {
        println("'$displayName' fainted!")
        fainted = true
    }
    fun reset() {
        fainted = false
    }

    fun battleCry() {
        println("'$displayName' says: $name!")
    }
}