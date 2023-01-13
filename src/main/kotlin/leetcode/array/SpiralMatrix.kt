package leetcode.array

/*
 * https://leetcode.com/problems/spiral-matrix/
 */

class SpiralMatrix {

    // right = 0, down = 1, left = 2, top = 3

    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val list = mutableListOf<Int>()
        traverse(matrix, row = 0, col = 0, direction = 0, list = list)
        return list
    }

    private fun traverse(
        matrix: Array<IntArray>,
        row: Int,
        col: Int,
        direction: Int,
        list: MutableList<Int>
    ) {

        if (list.size == matrix.size * matrix[0].size) return

        list.add(matrix[row][col])
        matrix[row][col] = -101

        when (direction) {
            0 -> {
                if (col + 1 < matrix[0].size && matrix[row][col + 1] != -101)
                    traverse(matrix, row, col + 1, 0, list)
                else
                    traverse(matrix, row + 1, col, 1, list)
            }

            1 -> {
                if (row + 1 < matrix.size && matrix[row + 1][col] != -101)
                    traverse(matrix, row + 1, col, 1, list)
                else
                    traverse(matrix, row, col - 1, 2, list)
            }

            2 -> {
                if (col - 1 >= 0 && matrix[row][col - 1] != -101)
                    traverse(matrix, row, col - 1, 2, list)
                else
                    traverse(matrix, row - 1, col, 3, list)
            }

            3 -> {
                if (row - 1 >= 0 && matrix[row - 1][col] != -101)
                    traverse(matrix, row - 1, col, 3, list)
                else
                    traverse(matrix, row, col + 1, 0, list)
            }
        }
    }

    fun spiralOrder2(matrix: Array<IntArray>): List<Int> {
        val list = mutableListOf<Int>()

        var top = 0
        var bottom = matrix.size

        var left = 0
        var right = matrix[0].size

        while (top < bottom && left < right) {

            // Go to right
            for (col in left until right) {
                list.add(matrix[top][col])
            }
            ++top

            // Go to down
            for (row in top until bottom) {
                list.add(matrix[row][right - 1])
            }
            --right

            if (left >= right || top >= bottom) break

            // Go to left
            for (col in right - 1 downTo left) {
                list.add(matrix[bottom - 1][col])
            }
            --bottom

            // Go to up
            for (row in bottom - 1 downTo top) {
                list.add(matrix[row][left])
            }
            ++left
        }

        return list
    }
}