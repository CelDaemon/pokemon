package net.voidgroup.pokemon

class Charmander(nickname: String) : Pokemon(nickname) {
    override val strength: Element
        get() = Element.FIRE
    override val weakness: Element
        get() = Element.WATER
    override val name: String
        get() = "Charmander"
}