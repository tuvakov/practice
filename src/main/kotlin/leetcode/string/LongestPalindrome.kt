package leetcode.string

/*
 * https://leetcode.com/problems/longest-palindrome
 */

class LongestPalindrome {

    fun longestPalindrome(s: String): Int {

        val counts = s.groupingBy { it }.eachCount().values

        var result = 0
        var handledOdd = false

        for (v in counts) {
            if (v % 2 == 0) {
                result += v
            } else {
                if (handledOdd) {
                    result += v - 1
                } else {
                    handledOdd = true
                    result += v
                }
            }
        }

        return result
    }
}