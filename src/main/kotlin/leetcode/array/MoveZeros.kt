package leetcode.array


/*
 * https://leetcode.com/problems/move-zeroes
 */

class MoveZeros {

    fun moveZeros(nums: IntArray) {

        var p = 0  // zero position
        var q = 0  // none zero position

        while (q < nums.lastIndex) {
            while (p <= nums.lastIndex && nums[p] != 0) p++
            q = p + 1
            while (q <= nums.lastIndex && nums[q] == 0) q++

            if (q > nums.lastIndex || p > nums.lastIndex) break

            nums[p] = nums[q]
            nums[q] = 0
        }
    }
}