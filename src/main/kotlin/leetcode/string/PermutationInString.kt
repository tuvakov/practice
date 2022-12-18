package leetcode.string

/*
 * https://leetcode.com/problems/permutation-in-string/
 */

class PermutationInString {
    fun checkInclusion(s1: String, s2: String): Boolean {

        if (s1.length > s2.length) return false

        val s1Map = s1.groupingBy { it }.eachCount()
        val s2Map = mutableMapOf<Char, Int>()

        var first = 0
        var second = 0
        var length = 0

        while (second < s2.length) {
            val current = s2[second++]
            s2Map[current] = s2Map.getOrDefault(current, 0) + 1
            length++

            if (length < s1.length) continue

            if (s1Map == s2Map) return true

            val char = s2[first++]
            val count = s2Map.getOrDefault(char, 1) - 1
            if (count == 0) s2Map.remove(char) else s2Map[char] = count
            length--
        }

        return false
    }
}