import Cell.O
import Cell.X
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class TicTacToeKtTest {

    @Test
    fun `can start a new TicTacToeBoard`() {
        assertTrue(TicTacToe().board.all { row -> row.all { it == null } } )

    }

    @Test
    fun `lateral win`() {
        val game = TicTacToe()
        game.board[0] = Array(3) { X }
        assertEquals(X, game.someoneWon())

        val game2 = TicTacToe()
        game2.board[1] = Array(3) { O }
        assertEquals(O, game2.someoneWon())

        val game3 = TicTacToe()
        game3.board[1] = Array(3) { X }
        assertEquals(X, game3.someoneWon())
    }

    @Test
    fun `vertical win`() {
        val game = TicTacToe()
        game.board[0][0] = X
        game.board[1][0] = X
        game.board[2][0] = X
        assertEquals(X, game.someoneWon())

        val game2 = TicTacToe()
        game2.board[0][1] = X
        game2.board[1][1] = X
        game2.board[2][1] = X
        assertEquals(X, game2.someoneWon())

        val game3 = TicTacToe()
        game3.board[0][2] = X
        game3.board[1][2] = X
        game3.board[2][2] = X
        assertEquals(X, game3.someoneWon())
    }

    @Test
    fun `diagonal win`() {
        val game = TicTacToe()
        game.board[0][0] = X
        game.board[1][1] = X
        game.board[2][2] = X
        assertEquals(X, game.someoneWon())

        val game2 = TicTacToe()
        game2.board[0][2] = X
        game2.board[1][1] = X
        game2.board[2][0] = X

        assertEquals(X, game2.someoneWon())
    }

    @Test
    fun `nobody wins game`() {
        val game = TicTacToe()
        game.board[0][0] = X
        game.board[0][1] = O
        game.board[0][2] = X
        game.board[1][0] = O
        game.board[1][1] = X
        game.board[1][2] = O
        game.board[2][0] = O
        game.board[2][1] = X
        game.board[2][2] = O
        assertEquals(null, game.someoneWon())
    }
}