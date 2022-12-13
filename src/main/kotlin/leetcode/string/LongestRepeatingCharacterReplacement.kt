package leetcode.string

/*
 * https://leetcode.com/problems/longest-repeating-character-replacement
 */

class LongestRepeatingCharacterReplacement {
    fun characterReplacement(s: String, k: Int): Int {
        val map = mutableMapOf<Char, Int>()
        var left = 0
        var right = 0
        var maxCount = 0

        while (right < s.length) {
            val current = s[right]
            val count = (map[current] ?: 0) + 1
            map[current] = count

            maxCount = maxOf(maxCount, count)

            val length = right - left + 1

            if (length - maxCount <= k) {
                right++
                continue
            }

            map[s[left]] = (map[s[left]] ?: 1) - 1
            left++
            right++
        }

        return right - left
    }
}