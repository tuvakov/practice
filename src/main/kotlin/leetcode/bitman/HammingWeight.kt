package leetcode.bitman

/*
 * https://leetcode.com/problems/number-of-1-bits
 */

class HammingWeight {

    fun hammingWeight(n: Int): Int {
        var result = 0
        var mask = 1
        repeat(32) {
            if (mask and n != 0) result++
            mask = mask shl 1
        }
        return result
    }

}