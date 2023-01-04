package leetcode.string

import java.lang.StringBuilder

/*
 * https://leetcode.com/problems/longest-common-prefix/
 */

class LongestCommonPrefix {
    fun longestCommonPrefix(strs: Array<String>): String {
        val builder = StringBuilder()
        val reference = strs.first()
        for (idx in reference.indices) {
            for (string in strs) {
                if (idx !in string.indices || reference[idx] != string[idx])
                    return builder.toString()
            }
            builder.append(reference[idx])
        }
        return builder.toString()
    }

    fun longestCommonPrefixSort(strs: Array<String>): String {
        strs.sort()

        val builder = StringBuilder()
        val first = strs.first()
        val last = strs.last()

        for (idx in first.indices) {
            if (idx !in last.indices || first[idx] != last[idx])
                return builder.toString()
            builder.append(first[idx])
        }

        return builder.toString()
    }
}