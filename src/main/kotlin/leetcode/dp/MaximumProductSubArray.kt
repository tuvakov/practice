package leetcode.dp

/*
 * https://leetcode.com/problems/maximum-product-subarray/
 */

class MaximumProductSubArray {
    fun maxProductBruteForce(nums: IntArray): Int {
        var max = Int.MIN_VALUE

        for (idx in nums.indices) {
            var local = 1
            for (jdx in idx..nums.lastIndex) {
                local *= nums[jdx]
                max = maxOf(max, local)
            }
        }

        return max
    }

    fun maxProduct(nums: IntArray): Int {
        var result = Int.MIN_VALUE
        var min = 1
        var max = 1

        for (num in nums) {
            val tmpMin = min * num
            val tmpMax = max * num
            max = maxOf(tmpMax, tmpMin, num)
            min = minOf(tmpMax, tmpMin, num)
            result = maxOf(result, max)
        }

        return result
    }
}