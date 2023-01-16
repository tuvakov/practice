package leetcode.math

/*
 * https://leetcode.com/problems/plus-one/
 */

class PlusOne {
    fun plusOne(digits: IntArray): IntArray {
        digits[digits.lastIndex]++
        if (digits.last() < 10) return digits

        var carry = 0
        for (idx in digits.indices.reversed()) {
            val sum = digits[idx] + carry
            val newDigit = sum % 10
            digits[idx] = newDigit
            carry = sum / 10
        }

        return if (carry == 0) digits else intArrayOf(carry) + digits
    }
}