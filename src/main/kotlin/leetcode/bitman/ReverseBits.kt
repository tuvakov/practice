package leetcode.bitman

/*
 * https://leetcode.com/problems/reverse-bits
 */

class ReverseBits {
    fun reverseBits(n: Int): Int {
        var result = 0
        repeat(32) { pos ->
            val bit = (n shr pos) and 1
            val mask = bit shl (31 - pos)
            result = result or mask
        }
        return result
    }
}