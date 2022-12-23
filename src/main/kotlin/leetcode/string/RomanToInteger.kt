package leetcode.string

/*
 * https://leetcode.com/problems/roman-to-integer/
 */

class RomanToInteger {

    fun romanToInt(roman: String): Int {
        var result = 0

        for (idx in 0..roman.lastIndex) {
            val current = roman[idx]
            val next = roman.getOrNull(idx + 1)
            result += when (current) {
                'I' -> if (next == 'V' || next == 'X') -1 else 1
                'X' -> if (next == 'L' || next == 'C') -10 else 10
                'C' -> if (next == 'D' || next == 'M') -100 else 100
                'V' -> 5
                'L' -> 50
                'D' -> 500
                'M' -> 1000
                else -> 0
            }
        }

        return result
    }
}