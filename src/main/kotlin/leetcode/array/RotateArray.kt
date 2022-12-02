package leetcode.array

/*
 * https://leetcode.com/problems/rotate-array
 */

class RotateArray {
    fun rotate(nums: IntArray, k: Int) {
        if (k == 0 || k == nums.size) return

        val result = IntArray(nums.size)
        val start = nums.size - (k % nums.size)

        var resultIdx = 0

        for (idx in start..nums.lastIndex)
            result[resultIdx++] = nums[idx]

        for (idx in 0 until start)
            result[resultIdx++] = nums[idx]

        for (idx in result.indices) nums[idx] = result[idx]
    }
}