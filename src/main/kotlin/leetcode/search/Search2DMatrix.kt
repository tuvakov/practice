package leetcode.search

/*
 * https://leetcode.com/problems/search-a-2d-matrix/
 */

class Search2DMatrix {

    fun searchMatrix(
        matrix: Array<IntArray>,
        target: Int
    ): Boolean {
        val row = verticalBinarySearch(matrix, target)

        if (row !in matrix.indices) return false

        return matrix[row].binarySearch(target) >= 0
    }

    private fun verticalBinarySearch(
        matrix: Array<IntArray>,
        target: Int
    ): Int {

        var start = 0
        var end = matrix.lastIndex

        while (start <= end) {
            val middle = (start + end) / 2
            if (matrix[middle][0] == target) return middle
            else if (target < matrix[middle][0]) end = middle - 1
            else start = middle + 1
        }

        return end
    }
}