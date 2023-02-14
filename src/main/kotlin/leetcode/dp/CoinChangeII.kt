package leetcode.dp

/*
 * https://leetcode.com/problems/coin-change-ii/
 */

class CoinChangeII {
    fun change(amount: Int, coins: IntArray): Int {
        coins.sort()
        val memo = mutableMapOf<String, Int>()
        return change(amount, coins, coins.lastIndex, memo)
    }

    private fun change(
        amount: Int,
        coins: IntArray,
        currentIdx: Int,
        memo: MutableMap<String, Int>
    ): Int {
        if (amount == 0) return 1

        if (amount < 0 || currentIdx < 0) return 0

        val key = "$amount-$currentIdx"

        if (key in memo) return memo[key]!!

        var result = 0

        for (idx in currentIdx downTo 0) {
            val newAmount = amount - coins[idx]
            result += change(newAmount, coins, idx, memo)
        }

        memo[key] = result

        return result
    }
}