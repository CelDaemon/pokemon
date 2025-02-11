package net.voidgroup.pokemon

fun main() {
    do {
        val challenger = Trainer(Input.readName("Enter the name for the challenger"))
        val opponent = Trainer(Input.readName("Enter the name for the opponent"))

        Battle(challenger, opponent).start()

    } while (Input.readBoolean("Do you want to restart?"))
}

