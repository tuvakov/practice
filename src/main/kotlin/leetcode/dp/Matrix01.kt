package leetcode.dp

import java.util.LinkedList

/*
 * https://leetcode.com/problems/01-matrix
 */

class Matrix01 {
    fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {

        val result = Array(mat.size) { IntArray(mat[0].size) { -1 } }

        for (row in mat.indices) {
            for (col in mat[0].indices) {
                if (result[row][col] == -1) {
                    bfs(mat, result, row, col)
                }
            }
        }

        return result
    }

    private fun bfs(
        mat: Array<IntArray>,
        result: Array<IntArray>,
        row: Int,
        col: Int
    ) {
        val queue = LinkedList<Node>()
        queue.add(Node(row, col, null))
        val seen = mutableSetOf<Pair<Int, Int>>()

        var current: Node? = null

        while (queue.isNotEmpty()) {
            current = queue.pop()

            if (mat[current.row][current.col] == 0) break

            val r = current.row
            val c = current.col

            seen.add(Pair(r, c))

            // up
            if (r - 1 >= 0 && Pair(r - 1, c) !in seen) {
                queue.add(Node(r - 1, c, current))
            }

            // down
            if (r + 1 < mat.size && Pair(r + 1, c) !in seen) {
                queue.add(Node(r + 1, c, current))
            }

            // left
            if (c - 1 >= 0 && Pair(r, c - 1) !in seen) {
                queue.add(Node(r, c - 1, current))
            }

            // right
            if (c + 1 < mat[0].size && Pair(r, c + 1) !in seen) {
                queue.add(Node(r, c + 1, current))
            }
        }

        var step = 0

        while (current != null) {
            result[current.row][current.col] = step++
            current = current.parent
        }
    }

    fun updateMatrix2(mat: Array<IntArray>): Array<IntArray> {

        val queue = LinkedList<Pair<Int, Int>>()

        for (row in mat.indices) {
            for (col in mat[0].indices) {
                if (mat[row][col] == 0) queue.add(Pair(row, col))
                else mat[row][col] = -1
            }
        }

        val directions = arrayListOf(
            Pair(-1, 0), Pair(1, 0), Pair(0, -1), Pair(0, 1)
        )

        while (queue.isNotEmpty()) {
            val (row, col) = queue.pop()

            for ((dr, dc) in directions) {
                val r = row + dr
                val c = col + dc
                if (r in mat.indices && c in mat[0].indices && mat[r][c] == -1) {
                    mat[r][c] = mat[row][col] + 1
                    queue.add(Pair(r, c))
                }
            }
        }

        return mat
    }

    data class Node(
        val row: Int,
        val col: Int,
        val parent: Node?
    )
}