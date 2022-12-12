package leetcode.dp

/*
 * https://leetcode.com/problems/climbing-stairs
 */

class ClimbingStairs {

    fun climbStairs(n: Int): Int {
        val memo = IntArray(n + 1) { -1 }
        return climbStairs(n, memo)
    }

    private fun climbStairs(n: Int, memo: IntArray): Int {
        if (n < 0) return 0
        if (memo[n] != -1) return memo[n]
        if (n == 0) return 1
        val result = climbStairs(n - 1, memo) + climbStairs(n - 2, memo)
        memo[n] = result
        return result
    }
}