package leetcode.dfs

/*
 * https://leetcode.com/problems/number-of-islands/
 */

class NumberOfIslands {
    fun numIslands(grid: Array<CharArray>): Int {
        var result = 0

        for (row in grid.indices) {
            for (col in grid[row].indices) {
                if (grid[row][col] == '1') {
                    dfs(grid, row, col)
                    result++
                }
            }
        }

        return result
    }

    private fun dfs(grid: Array<CharArray>, row: Int, col: Int) {
        grid[row][col] = '0'

        // up
        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
            dfs(grid, row - 1, col)
        }

        // down
        if (row + 1 < grid.size && grid[row + 1][col] == '1') {
            dfs(grid, row + 1, col)
        }

        // left
        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
            dfs(grid, row, col - 1)
        }

        // right
        if (col + 1 < grid[row].size && grid[row][col + 1] == '1') {
            dfs(grid, row, col + 1)
        }
    }
}