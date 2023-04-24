package tictactoe

fun main() {
    startGame()
}

fun startGame() {
    var gridList = createGrid()
    printGrid(gridList)

    while (!checkFinished(gridList)) {
        gridList = move(gridList)
        printGrid(gridList)
    }
}

fun createGrid(): MutableList<MutableList<Char>> {
    return MutableList(3) { MutableList(3) { ' ' } }
}

fun move(gridList: MutableList<MutableList<Char>>):  MutableList<MutableList<Char>> {
    var done = false
    while (!done) {
        val move = readln()
        if (!move.matches("\\d \\d".toRegex())) {
            println("You should enter numbers!")
        } else {
            val moves = move.split(" ").map { it.toInt() }.toMutableList()
            val x = moves[0] - 1
            val y = moves[1] - 1

            if (x > 2 || x < 0 || y > 2 || y < 0) {
                println("Coordinates should be from 1 to 3!")
            } else if (gridList[x][y] == 'X' || gridList[x][y] == 'O') {
                println("This cell is occupied! Choose another one!")
            } else {
                gridList[x][y] = nextMove(gridList)
                done = true
            }
        }
    }
    return  gridList
}

fun nextMove(gridList:  MutableList<MutableList<Char>>): Char {
    val countX = gridList.joinToString("").count{ it == 'X'}
    val countO = gridList.joinToString("").count{ it == 'O'}
    return if (countO >= countX) {
        'X'
    } else 'O'
}

fun checkFinished(list: MutableList<MutableList<Char>>): Boolean {
    var isFinished = true
    val winners = mutableListOf(
        mutableListOf(list[0][0], list[0][1], list[0][2]),
        mutableListOf(list[1][0], list[1][1], list[1][2]),
        mutableListOf(list[2][0], list[2][1], list[2][2]),
        mutableListOf(list[0][0], list[1][0], list[2][0]),
        mutableListOf(list[0][1], list[1][1], list[2][1]),
        mutableListOf(list[0][2], list[1][2], list[2][2]),
        mutableListOf(list[0][0], list[1][1], list[2][2]),
        mutableListOf(list[0][2], list[1][1], list[2][0])
    )

    var xWins = false
    var oWins = false

    val containsFreeCell = list.joinToString("") { it.joinToString("") }.contains(' ')
    for (line in winners) {
        if (line.joinToString("") == "XXX") xWins = true
        if (line.joinToString("") == "OOO") oWins = true
    }

    if (xWins) {
        println("X wins")
    } else if (oWins) {
        println("O wins")
    } else if (!containsFreeCell) {
        println("Draw")
    } else {
        isFinished = false
    }
    return isFinished
}

fun printGrid(list: MutableList<MutableList<Char>>) {
    println("---------")
    println("| ${list[0][0]} ${list[0][1]} ${list[0][2]} |")
    println("| ${list[1][0]} ${list[1][1]} ${list[1][2]} |")
    println("| ${list[2][0]} ${list[2][1]} ${list[2][2]} |")
    println("---------")
}