package leetcode.string

import java.util.Stack

/*
 * https://leetcode.com/problems/backspace-string-compare/
 */

class BackspaceStringCompare {

    fun backspaceCompare(s: String, t: String): Boolean {
        return process(s) == process(t)
    }

    private fun process(str: String): String {
        val stack = Stack<Char>()
        for (char in str) {
            if (char != '#') {
                stack.add(char)
                continue
            }
            if (stack.isNotEmpty()) stack.pop()
        }
        return stack.toString()
    }
}