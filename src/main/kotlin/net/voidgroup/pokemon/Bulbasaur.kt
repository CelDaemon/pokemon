package net.voidgroup.pokemon

class Bulbasaur(nickname: String) : Pokemon(nickname) {
    override val strength: Element
        get() = Element.Leaf
    override val weakness: Element
        get() = Element.Fire
    override val name: String
        get() = "Bulbasaur"
}