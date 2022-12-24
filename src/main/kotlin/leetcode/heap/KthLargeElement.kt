package leetcode.heap

import java.util.PriorityQueue

/*
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */

class KthLargeElement {
    fun findKthLargest(nums: IntArray, k: Int): Int {

        val heap = PriorityQueue<Int>()

        for (num in nums) {

            if (heap.size < k) {
                heap.add(num)
                continue
            }

            val min = heap.peek()

            if (num < min) continue

            heap.remove()
            heap.add(num)

            assert(heap.size == k)
        }

        return heap.peek()
    }

    fun findKthLargest2(nums: IntArray, k: Int): Int {
        nums.sort()
        return nums[nums.size - k]
    }
}