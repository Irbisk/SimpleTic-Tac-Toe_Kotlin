fun main() {
    val grid = MutableList(5) { MutableList(5) { 0 } }
    repeat(3) {
        val xy = readln().split(" ").map { it.toInt() - 1 }.toMutableList()
        grid[xy[0]][xy[1]] = 1
    }
    val listX = mutableListOf<Int>()
    val listY = mutableListOf<Int>()
    for (x in grid.indices) {
        var existsX = false
        var existsY = false
        for (y in grid[x].indices) {
            if (grid[x][y] == 1) {
                existsX = true
            }
            if (grid[y][x] == 1) {
                existsY = true
            }
        }
        if (!existsY) {
            listY.add(x + 1)
        }
        if (!existsX) {
            listX.add(x + 1)
        }
    }
    println(listX.joinToString(" "))
    println(listY.joinToString(" "))
}