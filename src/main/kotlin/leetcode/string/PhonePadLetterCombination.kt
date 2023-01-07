package leetcode.string

import java.lang.StringBuilder

/*
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */

class PhonePadLetterCombination {
    fun letterCombinations(digits: String): List<String> {

        val letters = mapOf(
            '2' to arrayOf("a", "b", "c"),
            '3' to arrayOf("d", "e", "f"),
            '4' to arrayOf("g", "h", "i"),
            '5' to arrayOf("j", "k", "l"),
            '6' to arrayOf("m", "n", "o"),
            '7' to arrayOf("p", "q", "r", "s"),
            '8' to arrayOf("t", "u", "v"),
            '9' to arrayOf("w", "x", "y", "z")
        )

        val result = mutableListOf<String>()
        letterCombinations(digits, 0, letters, result, path = StringBuilder())
        return result
    }

    private fun letterCombinations(
        digits: String,
        idx: Int,
        map: Map<Char, Array<String>>,
        result: MutableList<String>,
        path: StringBuilder
    ) {

        if (idx > digits.lastIndex) {
            if (path.isNotEmpty()) result.add(path.toString())
            return
        }

        val digit = digits[idx]
        val chars = map.getOrDefault(digit, emptyArray())

        for (char in chars) {
            path.append(char)
            letterCombinations(digits, idx + 1, map, result, path)
            path.deleteCharAt(path.lastIndex)
        }
    }
}