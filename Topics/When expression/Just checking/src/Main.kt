fun main() {
    val n = readln().toInt()

    print(when (n) {
        1 -> "No!"
        2 -> "Yes!"
        in 3..4 -> "No!"
        else -> "Unknown number"
    })

}