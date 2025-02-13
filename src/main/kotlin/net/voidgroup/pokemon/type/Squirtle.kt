package net.voidgroup.pokemon.type

import net.voidgroup.pokemon.Element
import net.voidgroup.pokemon.Pokemon
import net.voidgroup.pokemon.Trainer

class Squirtle(nickname: String, owner: Trainer) : Pokemon(nickname, owner) {
    override val strength: Element
        get() = Element.WATER
    override val weakness: Element
        get() = Element.LEAF
    override val name: String
        get() = "Squirtle"
}