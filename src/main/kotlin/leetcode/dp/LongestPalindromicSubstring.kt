package leetcode.dp

/*
 * https://leetcode.com/problems/longest-palindromic-substring/
 */

class LongestPalindromicSubstring {
    fun longestPalindrome(s: String): String {

        var answer = ""

        for (idx in s.indices) {

            // Odd palindrome
            var left = idx
            var right = idx
            while (left >= 0 && right <= s.lastIndex && s[left] == s[right]) {
                if (right - left + 1 > answer.length) {
                    answer = s.substring(left, right + 1)
                }
                left--
                right++
            }

            // Even palindrome
            left = idx
            right = idx + 1
            while (left >= 0 && right <= s.lastIndex && s[left] == s[right]) {
                if (right - left + 1 > answer.length) {
                    answer = s.substring(left, right + 1)
                }
                left--
                right++
            }
        }

        return answer
    }
}