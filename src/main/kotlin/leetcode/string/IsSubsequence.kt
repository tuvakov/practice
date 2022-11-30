package leetcode.string

/*
 * https://leetcode.com/problems/is-subsequence
 */

class IsSubsequence {
    fun isSubsequence(s: String, t: String): Boolean {
        var sIdx = 0
        var tIdx = 0
        while (sIdx <= s.lastIndex && tIdx <= t.lastIndex) {
            if (s[sIdx] == t[tIdx++]) sIdx++
        }
        return sIdx > s.lastIndex
    }
}