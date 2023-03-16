package leetcode.string

/*
 * https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words
 */

class LongestPalindromeByConcat {
    fun longestPalindrome(words: Array<String>): Int {

        val map = words.groupingBy { it }.eachCount()

        var answer = 0

        var handledOdd = false

        for ((word, count) in map) {

            val reverse = word.reversed()

            if (reverse == word) {
                if (count % 2 == 0) {
                    answer += count * 2
                    continue
                }
                answer += (count - 1) * 2
                handledOdd = true
                continue
            }

            if (reverse in map) {
                val reverseCount = map[reverse]!!
                answer += minOf(count, reverseCount) * 2
            }
        }

        return if (handledOdd) answer + 2 else answer
    }
}