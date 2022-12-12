package leetcode.dp

/*
 * https://leetcode.com/problems/min-cost-climbing-stairs
 */

class MinCostClimbingStairs {
    fun minCostClimbingStairs(cost: IntArray): Int {
        val memo = IntArray(cost.size + 1) { -1 }
        return minOf(climb(cost, memo, 0), climb(cost, memo, 1))
    }

    private fun climb(cost: IntArray, memo: IntArray, step: Int): Int {
        if (step >= cost.size) return 0

        if (memo[step] != -1) return memo[step]

        val option1 = climb(cost, memo, step + 1)
        val option2 = climb(cost, memo, step + 2)
        val c = cost[step]

        val result = c + minOf(option1, option2)
        memo[step] = result

        return result
    }
}