package leetcode.math

import java.lang.StringBuilder
import java.util.LinkedList

class MultiplyStrings {
    fun multiply(num1: String, num2: String): String {

        if (num1 == "0" || num2 == "0") return "0"

        val multiplications = mutableListOf<LinkedList<Int>>()

        for ((trailingZeroCnt, idx2) in num2.indices.reversed().withIndex()) {

            val list = LinkedList<Int>()
            repeat(trailingZeroCnt) { list.add(0) }

            val digit2 = Character.getNumericValue(num2[idx2])
            var carry = 0

            for (idx1 in num1.indices.reversed()) {
                val digit1 = Character.getNumericValue(num1[idx1])
                val product = digit1 * digit2 + carry
                list.push(product % 10)
                carry = product / 10
            }

            if (carry != 0) list.push(carry)

            multiplications.add(list)
        }

        val multiplicationLength = multiplications.last().size

        for (list in multiplications) {
            val diff = multiplicationLength - list.size
            repeat(diff) { list.push(0) }
        }

        val result = StringBuilder()

        var idx = multiplicationLength - 1
        var sum = 0
        var carry = 0

        while (idx >= 0) {
            sum += carry
            for (list in multiplications) {
                sum += list[idx]
            }
            result.append(sum % 10)
            carry = sum / 10
            sum = 0
            idx--
        }

        if (carry != 0) result.append(carry)

        return result.reversed().toString()
    }
}