package leetcode.array

/*
 * https://leetcode.com/problems/squares-of-a-sorted-array
 */

class SortedSquares {

    fun sortedSquares(nums: IntArray): IntArray {

        var negativeIdx = -1

        for (idx in nums.indices) {
            if (nums[idx] < 0) negativeIdx = idx
            nums[idx] = nums[idx] * nums[idx]
        }

        if (negativeIdx < 0) return nums

        val result = IntArray(nums.size)
        var idx = negativeIdx + 1
        var resultIdx = 0

        while (resultIdx <= result.lastIndex) {

            if (idx > nums.lastIndex) {
                result[resultIdx++] = nums[negativeIdx--]
                continue
            }

            if (negativeIdx < 0) {
                result[resultIdx++] = nums[idx++]
                continue
            }

            result[resultIdx++] = if (nums[idx] < nums[negativeIdx]) nums[idx++]
            else nums[negativeIdx--]
        }

        return result
    }
}