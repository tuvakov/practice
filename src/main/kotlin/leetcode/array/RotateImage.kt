package leetcode.array

/*
 * https://leetcode.com/problems/rotate-image/
 */
class RotateImage {
    fun rotate(matrix: Array<IntArray>) {

        for (row in matrix.indices) {
            for (col in row + 1..matrix[0].lastIndex) {
                val temp = matrix[row][col]
                matrix[row][col] = matrix[col][row]
                matrix[col][row] = temp
            }
        }

        for (row in matrix.indices) {
            var start = 0
            var end = matrix[0].lastIndex
            while (start < end) {
                val temp = matrix[row][start]
                matrix[row][start] = matrix[row][end]
                matrix[row][end] = temp
                start++
                end--
            }
        }
    }
}