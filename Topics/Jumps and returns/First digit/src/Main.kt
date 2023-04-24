fun main() {
    val a = readln().split("").toMutableList()
    for (i in a) {
        if (i.matches("\\d".toRegex())) {
            println(i)
            break
        }
    }

}