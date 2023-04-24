fun main() {
    val first = readln()
    val command = readln()
    val second = readln()

    when (command) {
        "equals" -> println(first == second)
        "plus" -> println(first + second)
        "endsWith" -> println(first.endsWith(second))
        else -> println("Unknown operation")
    }
}