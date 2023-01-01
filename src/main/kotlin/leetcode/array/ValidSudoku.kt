package leetcode.array

/*
 * https://leetcode.com/problems/valid-sudoku/
 */
class ValidSudoku {
    fun isValidSudoku(board: Array<CharArray>): Boolean {

        val map = mutableMapOf<String, MutableSet<Char>>()

        for (row in board.indices) {
            for (col in board[0].indices) {

                val item = board[row][col]

                if (item == '.') continue

                val rowKey = "$row-row"
                val colKey = "$col-col"
                val sqKey = "${row / 3}-${col / 3}-sq"

                val rowSet = map.getOrDefault(rowKey, mutableSetOf())
                if (item in rowSet) return false
                rowSet.add(item)
                map[rowKey] = rowSet

                val colSet = map.getOrDefault(colKey, mutableSetOf())
                if (item in colSet) return false
                colSet.add(item)
                map[colKey] = colSet

                val sqSet = map.getOrDefault(sqKey, mutableSetOf())
                if (item in sqSet) return false
                sqSet.add(item)
                map[sqKey] = sqSet
            }
        }

        return true
    }
}