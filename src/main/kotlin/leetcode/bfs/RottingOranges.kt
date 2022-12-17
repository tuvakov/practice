package leetcode.bfs

import java.util.LinkedList

/*
 * https://leetcode.com/problems/rotting-oranges/
 */

class RottingOranges {

    fun orangesRotting(grid: Array<IntArray>): Int {

        val queue = LinkedList<Pair<Int, Int>>()
        val deliminator = Pair(-1, -1)
        var minutes = 0
        var oneCounter = 0

        for (row in grid.indices) {
            for (col in grid[0].indices) {
                if (grid[row][col] == 1) oneCounter++
                else if (grid[row][col] == 2) queue.add(Pair(row, col))
            }
        }

        if (oneCounter == 0) return 0

        queue.add(deliminator)
        val directions = arrayListOf(
            Pair(-1, 0), Pair(1, 0), Pair(0, -1), Pair(0, 1)
        )

        while (queue.isNotEmpty()) {
            val current = queue.pop()
            if (current == deliminator) {
                if (queue.isEmpty()) break
                minutes++
                queue.add(deliminator)
                continue
            }

            val (row, col) = current

            for ((dr, dc) in directions) {
                val r = row + dr
                val c = col + dc
                if (r in grid.indices && c in grid[0].indices && grid[r][c] == 1) {
                    oneCounter--
                    grid[r][c] = 2
                    queue.add(Pair(r, c))
                }
            }
        }

        return if (oneCounter != 0) return -1 else minutes
    }

    fun orangesRotting2(grid: Array<IntArray>): Int {

        val queue = LinkedList<Pair<Int, Int>>()
        var minutes = 0
        var oneCount = 0

        for (row in grid.indices) {
            for (col in grid[0].indices) {
                if (grid[row][col] == 1) oneCount++
                else if (grid[row][col] == 2) queue.add(Pair(row, col))
            }
        }

        if (oneCount == 0) return 0

        val directions = arrayListOf(
            Pair(-1, 0), Pair(1, 0), Pair(0, -1), Pair(0, 1)
        )

        while (queue.isNotEmpty()) {
            val size = queue.size
            minutes++

            repeat(size) {
                val (row, col) = queue.pop()
                for ((dr, dc) in directions) {
                    val r = row + dr
                    val c = col + dc
                    if (r in grid.indices && c in grid[0].indices && grid[r][c] == 1) {
                        grid[r][c] = 2
                        queue.add(Pair(r, c))
                        oneCount--
                    }
                }
            }
        }

        return if (oneCount != 0) -1 else minutes - 1
    }
}