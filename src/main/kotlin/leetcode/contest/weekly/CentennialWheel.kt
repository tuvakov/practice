package leetcode.contest.weekly

/*
 * Link: https://leetcode.com/problems/maximum-profit-of-operating-a-centennial-wheel/
 */

class CentennialWheel {
    fun minOperationsMaxProfit(
        customerArr: IntArray,
        boardingCost: Int,
        runningCost: Int
    ): Int {
        var rem = 0
        var rotations = 0
        var customers = 0
        val max = intArrayOf(-1, Int.MIN_VALUE)

        for (customer in customerArr) {
            ++rotations
            rem += customer
            val result = if (rem < 4) rem else 4
            customers += result
            rem -= result
            val profit = customers * boardingCost - rotations * runningCost
            compare(max, rotations, profit)
        }

        while (rem > 0) {
            ++rotations
            val result = if (rem < 4) rem else 4
            customers += result
            rem -= result
            val profit = customers * boardingCost - rotations * runningCost
            compare(max, rotations, profit)
        }

        return if (max[1] <= 0) return -1 else max[0]
    }

    private fun compare(max: IntArray, rotations: Int, profit: Int) {
        if (max[1] < profit) {
            max[0] = rotations
            max[1] = profit
        }
    }
}