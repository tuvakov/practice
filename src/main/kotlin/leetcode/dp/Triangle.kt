package leetcode.dp

/*
 * https://leetcode.com/problems/triangle/
 */

class Triangle {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        val memo = mutableMapOf<String, Int>()
        return minimumTotal(triangle, memo, 0, 0)
    }

    private fun minimumTotal(
        triangle: List<List<Int>>,
        memo: MutableMap<String, Int>,
        row: Int,
        col: Int
    ): Int {

        val key = "$row:$col"
        if (key in memo) return memo[key]!!

        if (row == triangle.lastIndex) return triangle[row][col]

        val first = minimumTotal(triangle, memo, row + 1, col)
        val second = minimumTotal(triangle, memo, row + 1, col + 1)
        val result = triangle[row][col] + minOf(first, second)
        memo[key] = result
        return result
    }
}