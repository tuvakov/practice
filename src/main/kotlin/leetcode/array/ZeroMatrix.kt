package leetcode.array

/*
 *  https://leetcode.com/problems/set-matrix-zeroes/
 */

class ZeroMatrix {

    fun setZeroes(matrix: Array<IntArray>) {
        val rowArr = IntArray(matrix.size) { -1 }
        val colArr = IntArray(matrix[0].size) { -1 }

        for (row in matrix.indices) {
            for (col in matrix[0].indices) {
                if (matrix[row][col] != 0) continue
                rowArr[row] = 0
                colArr[col] = 0
            }
        }

        for (row in matrix.indices) {
            for (col in matrix[0].indices) {
                if (rowArr[row] == 0 || colArr[col] == 0) matrix[row][col] = 0
            }
        }
    }

    fun setZeroes2(matrix: Array<IntArray>) {

        var colZero = -1
        for (row in matrix.indices) {
            for (col in matrix[0].indices) {
                if (matrix[row][col] != 0) continue
                matrix[row][0] = 0                                  // row
                if (col == 0) colZero = 0 else matrix[0][col] = 0   // col
            }
        }

        for (row in 1..matrix.lastIndex) {
            for (col in 1..matrix[0].lastIndex) {
                if (matrix[row][0] == 0 || matrix[0][col] == 0)
                    matrix[row][col] = 0
            }
        }

        for (col in matrix[0].indices) {
            if (matrix[0][0] != 0) break
            matrix[0][col] = 0
        }

        for (row in matrix.indices) {
            if (colZero != 0) break
            matrix[row][0] = 0
        }
    }
}