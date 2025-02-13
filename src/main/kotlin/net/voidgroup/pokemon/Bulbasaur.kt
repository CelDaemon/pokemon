package net.voidgroup.pokemon

class Bulbasaur(nickname: String) : Pokemon(nickname) {
    override val strength: Element
        get() = Element.LEAF
    override val weakness: Element
        get() = Element.FIRE
    override val name: String
        get() = "Bulbasaur"
}