package leetcode.dp

/*
 * https://leetcode.com/problems/unique-paths
 */

class UniquePaths {
    fun uniquePaths(m: Int, n: Int): Int {
        val memo = Array(m) { IntArray(n) { -1 } }
        return uniquePaths(row = 0, col = 0, m = m - 1, n = n - 1, memo = memo)
    }

    private fun uniquePaths(
        row: Int,
        col: Int,
        m: Int,
        n: Int,
        memo: Array<IntArray>
    ): Int {
        if (row == m && col == n) return 1

        if (memo[row][col] != -1) return memo[row][col]

        var result = 0

        // down
        if (row + 1 <= m) {
            result += uniquePaths(row + 1, col, m, n, memo)
        }

        // right
        if (col + 1 <= n) {
            result += uniquePaths(row, col + 1, m, n, memo)
        }

        memo[row][col] = result

        return result
    }
}