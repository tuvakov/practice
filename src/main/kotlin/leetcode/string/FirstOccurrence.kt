package leetcode.string

/*
 * https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
 */

class FirstOccurrence {
    fun findFirstOccurrence(
        haystack: String,
        needle: String
    ): Int {

        for (idx in haystack.indices) {

            if (idx + needle.lastIndex > haystack.lastIndex) break

            var isSubstring = true

            for (jdx in needle.indices) {
                if (haystack[idx + jdx] == needle[jdx]) continue
                isSubstring = false
                break
            }

            if (isSubstring) return idx
        }

        return -1
    }
}