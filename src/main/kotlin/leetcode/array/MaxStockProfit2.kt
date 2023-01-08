package leetcode.array

/*
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */

class MaxStockProfit2 {

    fun maxProfitGreedy(prices: IntArray): Int {
        var result = 0
        for (i in 0 until prices.lastIndex) {
            result += maxOf(prices[i + 1] - prices[i], 0)
        }
        return result
    }
    fun maxProfitDp(prices: IntArray): Int {
        val memo = mutableMapOf<String, Int>()
        val result = maxProfitDp(prices, 0, 0, memo)
        return maxOf(result, 0)
    }

    private fun maxProfitDp(
        prices: IntArray,
        sellIdx: Int,
        boughtIdx: Int,
        memo: MutableMap<String, Int>
    ): Int {
        if (sellIdx > prices.lastIndex) return 0

        val key = "$boughtIdx:$sellIdx"

        if (key in memo) return memo[key]!!

        val sellPrice = prices[sellIdx]
        val boughtPrice = prices[boughtIdx]

        val profit = sellPrice - boughtPrice

        val nextIdx = sellIdx + 1

        if (nextIdx > prices.lastIndex) return profit

        val keptAndContinued = maxProfitDp(prices, nextIdx, boughtIdx, memo)
        val soldAndContinued = maxProfitDp(prices, nextIdx, nextIdx, memo)

        val result = maxOf(profit, profit + soldAndContinued, keptAndContinued)
        memo[key] = result

        return result
    }
}