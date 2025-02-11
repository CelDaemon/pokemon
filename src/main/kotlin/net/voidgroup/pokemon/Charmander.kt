package net.voidgroup.pokemon

class Charmander(var nickname: String, val strength: Element = Element.Fire, val weakness: Element = Element.Water) {
    fun battleCry() {
        println("${nickname}!")
    }
}