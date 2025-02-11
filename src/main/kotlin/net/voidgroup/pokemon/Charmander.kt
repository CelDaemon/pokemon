package net.voidgroup.pokemon

class Charmander(var nickname: String) {
    companion object {
        val STRENGTH = Element.Fire
        val WEAKNESS = Element.Water
    }
    fun battleCry() {
        println("${nickname}!")
    }
}