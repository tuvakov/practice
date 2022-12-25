package leetcode.bitman

/*
 * https://leetcode.com/problems/power-of-two
 */

class PowerOfTwo {

    fun isPowerOfTwoBitwise(n: Int) = if (n > 0) (n and n - 1) == 0 else false

    fun isPowerOfTwo(n: Int): Boolean {
        if (n <= 0) return false
        var pow = 1
        while (pow < n) pow *= 2
        return pow == n
    }

}