package leetcode.string

/*
 * https://leetcode.com/problems/decode-string/
 */

import java.lang.StringBuilder
import java.util.Stack

class DecodeString {

    fun decodeString(s: String): String {
        val stack = Stack<Char>()

        for (char in s) {
            if (char == ']') process(stack)
            else stack.push(char)
        }

        return stack.joinToString("") { it.toString() }
    }

    private fun process(stack: Stack<Char>) {

        val builder = StringBuilder()
        while (stack.isNotEmpty()) {
            val popped = stack.pop()
            if (popped == '[') break
            builder.append(popped)
        }

        val digitBuilder = StringBuilder()
        while (stack.isNotEmpty()) {
            val peeked = stack.peek()
            if (!peeked.isDigit()) break
            digitBuilder.append(stack.pop())
        }

        val digit = Integer.valueOf(digitBuilder.reversed().toString())
        for (i in 0 until digit) {
            for (idx in builder.lastIndex downTo 0) stack.push(builder[idx])
        }
    }
}