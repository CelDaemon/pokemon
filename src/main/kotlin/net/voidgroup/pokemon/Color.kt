package net.voidgroup.pokemon

@Suppress("Unused")
enum class Color(private val text: String) {
    BLACK("0;30"),
    RED("0;31"),
    GREEN("0;32"),
    YELLOW("0;33"),
    BLUE("0;34"),
    PURPLE("0;35"),
    CYAN("0;36"),
    WHITE("0;37"),

    BRIGHT_BLACK("1;30"),
    BRIGHT_RED("1;31"),
    BRIGHT_GREEN("1;32"),
    BRIGHT_YELLOW("1;33"),
    BRIGHT_BLUE("1;34"),
    BRIGHT_PURPLE("1;35"),
    BRIGHT_CYAN("1;36"),
    BRIGHT_WHITE("1;37"),

    RESET("0");

    companion object {
        private const val ESCAPE: Char = '\u001b'
    }

    override fun toString(): String {
        return "$ESCAPE[${text}m"
    }


}