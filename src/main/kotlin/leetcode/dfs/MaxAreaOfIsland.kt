package leetcode.dfs

/*
 * https://leetcode.com/problems/max-area-of-island
 */

class MaxAreaOfIsland {

    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        var result = 0

        for (row in grid.indices) {
            for (col in grid[row].indices) {
                if (grid[row][col] == 1) {
                    val count = dfs(grid, row, col)
                    result = maxOf(result, count)
                }
            }
        }

        return result
    }

    private fun dfs(grid: Array<IntArray>, row: Int, col: Int): Int {
        grid[row][col] = 0

        var count = 1

        // up
        if (row - 1 >= 0 && grid[row - 1][col] == 1) {
            count += dfs(grid, row - 1, col)
        }

        // down
        if (row + 1 < grid.size && grid[row + 1][col] == 1) {
            count += dfs(grid, row + 1, col)
        }

        // left
        if (col - 1 >= 0 && grid[row][col - 1] == 1) {
            count += dfs(grid, row, col - 1)
        }

        // right
        if (col + 1 < grid[row].size && grid[row][col + 1] == 1) {
            count += dfs(grid, row, col + 1)
        }

        return count
    }
}