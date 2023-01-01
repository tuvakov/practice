package leetcode.array

/*
 * https://leetcode.com/problems/maximum-subarray/
 */

class MaximumSubArray {
    fun maxSubArray(nums: IntArray): Int {
        var global = Int.MIN_VALUE
        var local = 0

        for (num in nums) {
            local = if (local + num > num) local + num else num
            global = maxOf(global, local)
        }

        return global
    }
}