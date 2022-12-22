package leetcode.dp

/*
 * https://leetcode.com/problems/house-robber/
 */

class HouseRobber {

    fun rob(nums: IntArray): Int {
        val memo = IntArray(nums.size) { -1 }
        return rob(nums, memo, nums.lastIndex)

    }

    private fun rob(nums: IntArray, memo: IntArray, idx: Int): Int {
        if (idx < 0) return 0
        if (memo[idx] != -1) return memo[idx]
        val beforePrev = rob(nums, memo, idx - 2) + nums[idx]
        val prev = rob(nums, memo, idx - 1)
        memo[idx] = maxOf(beforePrev, prev)
        return memo[idx]
    }
}