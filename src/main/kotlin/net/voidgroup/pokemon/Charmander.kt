package net.voidgroup.pokemon

class Charmander(nickname: String) : Pokemon(nickname) {
    override val strength: Element
        get() = Element.Fire
    override val weakness: Element
        get() = Element.Water
    override val name: String
        get() = "Charmander"
}