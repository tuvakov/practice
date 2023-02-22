package leetcode.dp

/*
 * https://leetcode.com/problems/where-will-the-ball-fall
 */
class WhereWillBallFall {
    fun findBall(grid: Array<IntArray>): IntArray {
        val answer = IntArray(grid[0].size)
        val memo = Array(grid.size) { IntArray(grid[0].size) { -2 } }
        for (col in grid[0].indices) {
            answer[col] = dropBallRec(grid, memo, 0, col)
        }
        for (row in memo) {
            println(row.contentToString())
        }
        return answer
    }

    private fun dropBallRec(
        grid: Array<IntArray>,
        memo: Array<IntArray>,
        row: Int,
        col: Int
    ): Int {

        if (col !in grid[0].indices) return -1

        if (row > grid.lastIndex) return col

        if (memo[row][col] != -2) return memo[row][col]

        val pane = grid[row][col]

        val nextPaneCol = col + pane
        if (nextPaneCol !in grid[0].indices) return -1

        val nextPane = grid[row][nextPaneCol]
        if (nextPane != pane) return -1

        memo[row][col] = dropBallRec(grid, memo, row + 1, nextPaneCol)

        return memo[row][col]
    }

    private fun dropBall(grid: Array<IntArray>, startingCol: Int): Int {
        var col = startingCol
        for (row in grid.indices) {
            val pane = grid[row][col]

            val nextPaneCol = col + pane
            if (nextPaneCol !in grid[0].indices) return -1

            val nextPane = grid[row][nextPaneCol]
            if (nextPane != pane) return -1

            col = nextPaneCol
        }

        return col
    }
}