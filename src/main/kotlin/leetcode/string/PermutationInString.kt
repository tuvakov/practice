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

    fun checkInclusion2(s1: String, s2: String): Boolean {

        if (s1.length > s2.length) return false

        val s1Freq = IntArray(26)
        val s2Freq = IntArray(26)

        for (idx in s1.indices) {
            s1Freq[s1[idx] - 'a']++
            s2Freq[s2[idx] - 'a']++
        }

        if (s1Freq.contentEquals(s2Freq)) return true

        for(idx in s1.length until s2.length) {
            val start = idx - s1.length
            s2Freq[s2[start] - 'a']--
            s2Freq[s2[idx] - 'a']++
            if (s1Freq.contentEquals(s2Freq)) return true
        }

        return false
    }
}