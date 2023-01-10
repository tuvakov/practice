package leetcode.dfs

/*
 * https://leetcode.com/problems/word-search/
 */

class WordSearch {
    fun exist(board: Array<CharArray>, word: String): Boolean {

        val seen = mutableSetOf<Pair<Int, Int>>()

        for (row in board.indices) {
            for (col in board[0].indices) {
                val position = Pair(row, col)
                val result = traverse(board, word, seen, position, 0)
                if (result) return true
            }
        }

        return false
    }

    private fun traverse(
        board: Array<CharArray>,
        word: String,
        seen: MutableSet<Pair<Int, Int>>,
        position: Pair<Int, Int>,
        idx: Int
    ): Boolean {

        if (idx == word.length) return true

        if (position in seen) return false

        val (row, col) = position

        if (row !in board.indices || col !in board[0].indices) return false

        if (board[row][col] != word[idx]) return false

        seen.add(position)

        val directions = listOf(
            Pair(-1, 0), Pair(1, 0), Pair(0, -1), Pair(0, 1)
        )

        for ((dr, dc) in directions) {
            val nextPos = Pair(row + dr, col + dc)
            val result = traverse(board, word, seen, nextPos, idx + 1)
            if (result) return true
        }

        seen.remove(position)

        return false
    }
}