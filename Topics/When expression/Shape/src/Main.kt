fun main(args: Array<String>) {
    val n = readln().toInt()
    var figure = ""

    when (n) {
        1 -> figure = "a square"
        2 -> figure = "a circle"
        3 -> figure = "a triangle"
        4 -> figure = "a rhombus"
    }
    if (figure.isEmpty()) {
        println("There is no such shape!")
    } else println("You have chosen $figure")
}