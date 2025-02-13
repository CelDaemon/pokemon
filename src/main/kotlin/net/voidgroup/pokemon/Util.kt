package net.voidgroup.pokemon

fun handleStringResponse(response: String): String? {
    val convertedResponse = response.trim()
    return convertedResponse.ifBlank { null }
}

fun readName(prompt: String): String {
    while (true) {
        print("${prompt}: ")
        handleStringResponse(readln())?.let { return it }
        println("Please enter a valid name.")
    }
}

fun handleBooleanResponse(response: String, default: Boolean? = false): Boolean? {
    val convertedResponse = response.trim().uppercase()
    if (convertedResponse == "Y" || convertedResponse == "YES" || convertedResponse == "TRUE" || (default == true && convertedResponse.isBlank())) return true
    if (convertedResponse == "N" || convertedResponse == "NO" || convertedResponse == "FALSE" || (default == false && convertedResponse.isBlank())) return false
    return null
}

fun readBoolean(prompt: String, default: Boolean? = false): Boolean {
    while (true) {
        print("$prompt (${if (default == true) 'Y' else 'y'}/${if (default == false) 'N' else 'n'}): ")
        handleBooleanResponse(readln(), default)?.let { return it }
        println("Please enter yes or no.")
    }
}

fun printHeader(title: String) {
    println(
        "\n${coloredString("===================", Color.BRIGHT_BLACK)} ${
            coloredString(
                title,
                Color.BRIGHT_GREEN
            )
        } ${coloredString("===================", Color.BRIGHT_BLACK)}"
    )
}

fun coloredString(text: String, color: Color) = "$color$text${Color.RESET}"