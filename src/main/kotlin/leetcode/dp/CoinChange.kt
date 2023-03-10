package leetcode.dp

/*
 * https://leetcode.com/problems/coin-change
 */

class CoinChange {
    fun coinChangeTopDown(coins: IntArray, amount: Int): Int {
        val map = mutableMapOf<Int, Int>()
        val answer = coinChangeTopDown(coins, map, amount)
        return if (answer == Int.MAX_VALUE) -1 else answer
    }

    private fun coinChangeTopDown(
        coins: IntArray,
        map: MutableMap<Int, Int>,
        amount: Int
    ): Int {

        if (amount == 0) return 0

        if (amount < 0) return Int.MAX_VALUE

        if (amount in map) return map[amount]!!

        var answer = Int.MAX_VALUE

        for (coin in coins) {
            val ans = coinChangeTopDown(coins, map, amount - coin)
            answer = minOf(ans, answer)
        }

        map[amount] = if (answer != Int.MAX_VALUE) answer + 1 else answer

        return map[amount]!!
    }

    fun coinChangeSet(coins: IntArray, amount: Int): Int {

        if (amount == 0) return 0

        var sums = mutableSetOf<Int>()
        for (coin in coins) sums.add(coin)

        var counter = 1

        while (true) {

            if (amount in sums) break

            val temp = mutableSetOf<Int>()

            for (sum in sums) {
                for (coin in coins) {
                    if (sum + coin <= amount)
                        temp.add(sum + coin)
                }
            }

            if (temp.isEmpty()) return -1

            sums = temp
            counter++
        }

        return counter
    }

    fun coinChangeBottomUp(coins: IntArray, amount: Int): Int {
        val defaultAmount = amount + 1
        val amounts = IntArray(amount + 1) { defaultAmount }
        amounts[0] = 0

        for (amountIdx in amounts.indices) {
            for (coin in coins) {
                if (amountIdx - coin < 0) continue
                amounts[amountIdx] =
                    minOf(amounts[amountIdx], 1 + amounts[amountIdx - coin])
            }
        }

        return if (amounts[amount] == defaultAmount) -1 else amounts[amount]
    }
}