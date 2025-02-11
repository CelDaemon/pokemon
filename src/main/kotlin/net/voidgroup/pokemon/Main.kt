package net.voidgroup.pokemon

fun validatePokemonNickname(nickname: String) = nickname.isNotBlank()
fun sanitizePokemonNickname(nickname: String) = nickname.trim()

fun readPokemonNickname(prompt: String): String {
    while (true) {
        print("${prompt}: ")
        val nickname = readln()
        if(validatePokemonNickname(nickname)) return sanitizePokemonNickname(nickname)
        println("Please enter a valid pokemon name.")
    }
}

fun main() {

    val charmander = Charmander(readPokemonNickname("Enter the name for the pokemon"))
    repeat(10) { charmander.battleCry() }

    while (true) {
        charmander.nickname = readPokemonNickname("Enter a new name for the pokemon")
        repeat(10) { charmander.battleCry() }
    }
}

