package leetcode.bitman

/*
 * https://leetcode.com/problems/number-of-1-bits
 */

class HammingWeight {

    fun hammingWeight(n: Int): Int {
        var result = 0
        var num = n
        repeat(32) {
            result += num and 1
            num = num shr 1
        }
        return result
    }

    fun hammingWeight2(n: Int): Int {
        var result = 0
        var num = n
        while (num != 0) {
            num = num and (num - 1)
            result++
        }
        return result
    }

}