package leetcode.array

/*
 * https://leetcode.com/problems/two-sum/
 */

class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {

        val map = mutableMapOf<Int, MutableList<Int>>()
        for (idx in nums.indices) {
            val num = nums[idx]
            val list = map[num] ?: mutableListOf()
            list.add(idx)
            map[num] = list
        }

        for (idx in nums.indices) {
            val num = nums[idx]
            val diff = target - num

            if (diff !in map) continue

            val list = map[diff]!!

            val secondIdx = list.firstOrNull { it != idx } ?: continue

            return intArrayOf(idx, secondIdx)
        }

        return intArrayOf()
    }
}