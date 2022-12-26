package leetcode.bitman

import kotlin.math.log2
import kotlin.math.pow

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

    fun isPowerOfTwoLog(n: Int): Boolean {
        if (n <= 0) return false
        val double = n.toDouble()
        val log = log2(double).toInt()
        return 2.0.pow(log) == double
    }

}