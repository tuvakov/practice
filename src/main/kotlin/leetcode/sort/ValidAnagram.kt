package leetcode.sort

class ValidAnagram {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        val sChars = s.toCharArray().sorted()
        val tChars = t.toCharArray().sorted()
        for (i in sChars.indices) {
            if (sChars[i] != tChars[i]) return false
        }
        return true
    }
}