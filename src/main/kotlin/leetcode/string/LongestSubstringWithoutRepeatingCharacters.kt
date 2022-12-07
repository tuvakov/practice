package leetcode.string

/*
 * Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */

class LongestSubstringWithoutRepeatingCharacters {
    fun lengthOfLongestSubstring(s: String): Int {
        if (s.isEmpty()) return 0
        var length = 0
        var left = 0
        var right = 0
        val seen = mutableSetOf<Char>()
        while (right < s.length) {
            val current = s[right]
            if (current !in seen) {
                length = maxOf(length, right - left + 1)
                seen.add(s[right])
                ++right
            } else {
                seen.remove(s[left++])
            }
        }
        return length
    }
}