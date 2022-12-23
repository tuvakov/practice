package leetcode.stack

import java.util.LinkedList

/*
 * https://leetcode.com/problems/valid-parentheses/
 */

class ValidParentheses {
    fun isValid(s: String): Boolean {

        val stack = LinkedList<Char>()

        for (char in s) {
            if (char == '{' || char == '(' || char == '[') {
                stack.push(char)
                continue
            }

            if (stack.isEmpty()) return false

            val opened = stack.pop()
            if (char == ')' && opened != '(') return false
            if (char == ']' && opened != '[') return false
            if (char == '}' && opened != '{') return false
        }

        return stack.isEmpty()
    }
}