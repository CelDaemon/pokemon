package net.voidgroup.pokemon.type

import net.voidgroup.pokemon.Element
import net.voidgroup.pokemon.Pokemon
import net.voidgroup.pokemon.Trainer

class Charmander(nickname: String, owner: Trainer) : Pokemon(nickname, owner) {
    override val strength: Element
        get() = Element.FIRE
    override val weakness: Element
        get() = Element.WATER
    override val name: String
        get() = "Charmander"
}