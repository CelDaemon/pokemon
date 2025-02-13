package net.voidgroup.pokemon

class Squirtle(nickname: String) : Pokemon(nickname) {
    override val strength: Element
        get() = Element.WATER
    override val weakness: Element
        get() = Element.LEAF
    override val name: String
        get() = "Squirtle"
}