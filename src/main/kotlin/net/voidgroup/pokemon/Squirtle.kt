package net.voidgroup.pokemon

class Squirtle(nickname: String) : Pokemon(nickname) {
    override val strength: Element
        get() = Element.Water
    override val weakness: Element
        get() = Element.Leaf
    override val name: String
        get() = "Squirtle"
}