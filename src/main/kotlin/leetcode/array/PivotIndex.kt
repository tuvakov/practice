package leetcode.array

/*
 * https://leetcode.com/problems/find-pivot-index
 */

class PivotIndex {
    fun pivotIndex(nums: IntArray): Int {

        val lefts = IntArray(nums.size)
        lefts[0] = nums[0]
        for (idx in 1..nums.lastIndex) {
            lefts[idx] = lefts[idx - 1] + nums[idx]
        }

        val rights = IntArray(nums.size)
        rights[nums.lastIndex] = nums[nums.lastIndex]
        for (idx in nums.lastIndex - 1 downTo 0) {
            rights[idx] = rights[idx + 1] + nums[idx]
        }

        for (idx in nums.indices) {
            if (lefts[idx] == rights[idx]) return idx
        }

        return -1
    }
}