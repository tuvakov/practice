package leetcode.permutation

import java.util.LinkedList

/*
 * https://leetcode.com/problems/subsets/
 */

class Subsets {
    fun subsets(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val list = LinkedList<Int>()
        result.add(list)
        for (idx in nums.indices) {
            subsets(nums, idx, LinkedList(), result)
        }
        return result
    }

    private fun subsets(
        nums: IntArray,
        idx: Int,
        list: LinkedList<Int>,
        result: MutableList<List<Int>>
    ) {

        list.add(nums[idx])
        result.add(mutableListOf<Int>().apply { addAll(list) })

        for (i in idx + 1..nums.lastIndex) {
            subsets(nums, i, list, result)
        }

        list.removeLast()
    }
}