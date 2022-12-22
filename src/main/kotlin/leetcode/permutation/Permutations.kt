package leetcode.permutation

import java.util.LinkedList

/*
 * https://leetcode.com/problems/permutations
 */

class Permutations {

    fun permute(nums: IntArray): Array<IntArray> {
        val result = mutableListOf<IntArray>()
        permute(nums.toList(), LinkedList(), result)
        return result.toTypedArray()
    }

    private fun permute(
        nums: List<Int>,
        seen: LinkedList<Int>,
        result: MutableList<IntArray>
    ) {
        if (nums.isEmpty()) {
            result.add(seen.toIntArray())
            return
        }

        for (idx in nums.indices) {
            val newNums = nums.filterIndexed { index, _ -> idx != index }
            seen.push(nums[idx])
            permute(newNums, seen, result)
            seen.pop()
        }
    }
}