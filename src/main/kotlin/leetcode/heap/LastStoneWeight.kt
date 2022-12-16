package leetcode.heap

import java.util.PriorityQueue

/*
 * https://leetcode.com/problems/last-stone-weight/
 */

class LastStoneWeight {

    fun lastStoneWeight(stones: IntArray): Int {
        val heap = PriorityQueue<Int>(reverseOrder())
        for (stone in stones) heap.add(stone)

        while (heap.size >= 2) {
            val first = heap.poll()
            val second = heap.poll()
            if (first == second) continue
            heap.add(first - second)
        }

        return if (heap.isEmpty()) 0 else heap.poll()
    }
}