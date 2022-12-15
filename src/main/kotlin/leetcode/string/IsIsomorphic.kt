package leetcode.string

/*
 * https://leetcode.com/problems/isomorphic-strings
 */

class IsIsomorphic {

    fun isIsomorphic(s: String, t: String): Boolean {
        val map = mutableMapOf<Char, Char>()

        for (idx in s.indices) {
            val sChar = s[idx]
            val tChar = t[idx]
            if (sChar in map) {
                if (map[sChar] != tChar) return false
            } else {
                if (!map.containsValue(tChar)) map[sChar] = tChar
                else return false
            }
        }

        return true
    }

    fun isIsomorphic2(s: String, t: String): Boolean {

        val sIndices = mutableMapOf<Char, MutableList<Int>>()

        for (idx in s.indices) {
            val sChar = s[idx]
            val sList = sIndices.getOrDefault(sChar, mutableListOf())
            sList.add(idx)
            sIndices[sChar] = sList
        }

        val charArr = CharArray(s.length)
        val seen = mutableSetOf<Char>()

        for (idx in t.indices) {

            val tChar = t[idx]
            val sChar = s[idx]

            if (tChar in seen) continue

            val sList = sIndices[sChar]!!
            for (i in sList) charArr[i] = tChar

            seen.add(tChar)
        }

        val result = charArr.joinToString("")

        return result == t
    }
}