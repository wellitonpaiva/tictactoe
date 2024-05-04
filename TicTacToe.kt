enum class Cell {
    X, O
}
class TicTacToe {
    val board: Array<Array<Cell?>> = Array(3) { Array(3) { null } }
    fun someoneWon(): Cell? {
        var winner: Cell? = null
        board.map { row ->
            if (row.all { it != null && it == row[0] }) {
                winner = row[0]
            }
        }
        board.transpose().map { row ->
            if (row.all { it != null && it == row[0] }) {
                winner = row[0]
            }
        }

        val diagonal = board.getDiagonal()
        if (diagonal.all { it != null && it == diagonal[0] }) {
            winner = diagonal[0]
        }
        val secondDiagonal = board.getSecondDiagonal()
        if (secondDiagonal.all { it != null && it == secondDiagonal[0] }) {
            winner = secondDiagonal[0]
        }

        return winner
    }
}

inline fun <reified T>Array<Array<T>>.transpose(): Array<Array<T>> =
    Array(this[0].size) { i -> Array(this.size) { j -> this[j][i] } }

inline fun <reified T>Array<Array<T>>.getDiagonal(): Array<T> =
    this.flatMapIndexed{ rowIndex, row -> row.filterIndexed { cellIndex, _ -> rowIndex == cellIndex}}.toTypedArray()

inline fun <reified T>Array<Array<T>>.getSecondDiagonal(): Array<T> =
    this.flatMapIndexed{ rowIndex, row -> row.filterIndexed { cellIndex, _ -> rowIndex == this.size - cellIndex - 1 } }.toTypedArray()

