package leetcode.math

/*
 * https://leetcode.com/problems/happy-number/
 */
class HappyNumber {
    fun isHappy(n: Int): Boolean {
        val seen = mutableSetOf<Int>()
        var number = n
        while (number !in seen) {
            seen.add(number)
            val sum = sumDigits(number)
            if (sum == 1) return true
            number = sum
        }
        return false
    }

    fun isHappyFloyd(n: Int): Boolean {
        var slow = n
        var fast = sumDigits(n)
        while (fast != 1 && fast != slow) {
            slow = sumDigits(slow)
            fast = sumDigits(sumDigits(fast))
        }
        return fast == 1
    }

    private fun sumDigits(n: Int): Int {
        var number = n
        var answer = 0
        while (number != 0) {
            val digit = number % 10
            answer += digit * digit
            number /= 10
        }
        return answer
    }
}