package net.voidgroup.pokemon

abstract class Pokemon(val nickname: String) {
    abstract val strength: Element
    abstract val weakness: Element
    abstract val name: String
    fun battleCry() {
        println("[$nickname]: $name!")
    }
}