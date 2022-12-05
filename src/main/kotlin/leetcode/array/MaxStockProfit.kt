package leetcode.array

/*
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock
 */

class MaxStockProfit {

    fun maxProfit(prices: IntArray): Int {

        val arr = IntArray(prices.size)
        var result = 0

        arr[arr.lastIndex] = prices[prices.lastIndex]

        for (idx in prices.lastIndex - 1 downTo 0) {
            val lastMax = arr[idx + 1]
            arr[idx] = if (prices[idx] > lastMax) prices[idx] else lastMax
        }

        for (idx in 0 until prices.lastIndex) {
            result = maxOf(result, arr[idx] - prices[idx])
        }

        return if (result > 0) result else 0
    }
}