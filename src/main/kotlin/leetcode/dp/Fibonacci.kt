package leetcode.dp

class Fibonacci {

    fun fib(n: Int): Int {
        val memo = IntArray(n + 1) { -1 }
        return fib(n, memo)
    }

    private fun fib(n: Int, memo: IntArray): Int {
        if (memo[n] != -1) {
            return memo[n]
        }
        if (n == 0) {
            memo[0] = 0
            return 0
        }
        if (n == 1) {
            memo[1] = 1
            return 1
        }
        val result = fib(n - 1, memo) + fib(n - 2, memo)
        memo[n] = result
        return result
    }
}