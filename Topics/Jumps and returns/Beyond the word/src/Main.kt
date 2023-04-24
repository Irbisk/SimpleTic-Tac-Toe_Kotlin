fun main() {
    val word = readln().split("").toMutableList()
    val alph = ('a'..'z').joinToString("").split("").toMutableList()
    for (w in word) {
        if (alph.contains(w)) alph.remove(w)
    }
    println(alph.joinToString(""))
}