package leetcode.string

/*
 * https://leetcode.com/problems/find-all-anagrams-in-a-string
 */

class FindAnagrams {

    fun findAnagrams(s: String, p: String): List<Int> {

        val pMap = p.groupingBy { it }.eachCount()
        val sMap = mutableMapOf<Char, Int>()
        val result = mutableListOf<Int>()

        var right = 0
        var left = 0
        var length = 0

        while (right < s.length) {

            val current = s[right]

            if (current !in pMap) {
                sMap.clear()
                length = 0
                left = ++right
                continue
            }

            val count = sMap[current] ?: 0
            sMap[current] = count + 1
            length++

            if (length != p.length) {
                right++
                continue
            }

            if (sMap == pMap) result.add(left)

            val first = s[left]
            if (first in sMap) sMap[first] = sMap[first]!! - 1

            left++
            right++
            length--
        }

        return result
    }
}