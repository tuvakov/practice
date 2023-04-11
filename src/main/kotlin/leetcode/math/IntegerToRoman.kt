package leetcode.math

import java.util.LinkedList

/*
 * https://leetcode.com/problems/integer-to-roman/
 */
class IntegerToRoman {

    private val romanNumerals = mapOf(
        1000 to "M",
        900 to "CM",
        500 to "D",
        400 to "CD",
        100 to "C",
        90 to "XC",
        50 to "L",
        40 to "XL",
        10 to "X",
        9 to "IX",
        5 to "V",
        4 to "IV",
        1 to "I"
    )

    fun intToRoman(num: Int): String {

        var n = num
        var places = 1
        val builder = LinkedList<String>()

        while (n != 0) {
            val digit = n % 10
            if (digit == 0) {
                n /= 10
                places *= 10
                continue
            }

            val digitWithPlaces = digit * places
            if (digitWithPlaces in romanNumerals) {
                builder.addFirst(romanNumerals[digitWithPlaces])
                n /= 10
                places *= 10
                continue
            }

            val fives = 5 * places
            val fivesRem = digitWithPlaces % fives
            val fivesDiv = digitWithPlaces / fives
            builder.addFirst(romanNumerals[places]!!.repeat(fivesRem / places))
            if (fivesDiv != 0) builder.addFirst(romanNumerals[fives])

            n /= 10
            places *= 10
        }

        return builder.joinToString("")
    }

    fun intToRoman2(num: Int): String {
        var remaining = num
        var result = ""
        for ((value, roman) in romanNumerals) {
            while (remaining >= value) {
                result += roman
                remaining -= value
            }
        }
        return result
    }
}