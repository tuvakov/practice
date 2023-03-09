package leetcode.array

import kotlin.math.abs

/*
 * https://leetcode.com/problems/3sum-closes
 */

class ThreeSumClosest {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        nums.sort()

        var answer = Int.MAX_VALUE

        for (idx in nums.indices) {
            val sum = twoSum(nums, idx, target)
            if (sum == target) return sum

            val diffSum = abs(target - sum)
            val diffAnswer = abs(target - answer)
            if (diffSum < diffAnswer) answer = sum
        }

        return answer
    }

    private fun twoSum(nums: IntArray, idx: Int, target: Int): Int {
        val first = nums[idx]
        var start = 0
        var end = nums.lastIndex
        var answer = Int.MAX_VALUE

        while (start < end) {

            if (start == idx) {
                start++
                continue
            } else if (end == idx) {
                end--
                continue
            }

            val second = nums[start]
            val third = nums[end]
            val sum = first + second + third

            if (sum == target) return sum

            if (sum > target) end--
            else start++

            val diffSum = abs(target - sum)
            val diffAnswer = abs(target - answer)

            if (diffSum < diffAnswer)
                answer = sum
        }

        return answer
    }
}