package leetcode.dp

import java.util.LinkedList

/*
 * https://leetcode.com/problems/word-break/
 */

class WordBreak {

    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val steps = wordDict.map { it.length }.toSet()
        val map = mutableMapOf<Int, Boolean>()
        return wordBreak(s, wordDict.toSet(), 0, steps, map)
    }

    private fun wordBreak(
        s: String,
        dict: Set<String>,
        start: Int,
        steps: Set<Int>,
        map: MutableMap<Int, Boolean>
    ): Boolean {

        if (start == s.length) return true

        if (start in map && map[start] == false) return false

        for (step in steps) {

            if (start + step > s.length) continue

            val word = s.subSequence(start, start + step)
            if (word !in dict) continue

            val result = wordBreak(s, dict, start + step, steps, map)

            if (result) return true
        }

        map[start] = false

        return false
    }

    fun wordBreakIterative(
        s: String,
        wordDict: List<String>
    ): Boolean {

        val dict = wordDict.toSet()
        val steps = wordDict.map { it.length }.toSet()
        val memo = BooleanArray(s.length) { true }
        val stack = LinkedList<Int>().apply { push(0) }

        while (stack.isNotEmpty()) {
            val last = stack.pop()

            if (last == s.length) return true

            if (!memo[last]) continue

            for (step in steps) {
                if (last + step > s.length) continue

                val word = s.subSequence(last, last + step)
                if (word !in dict) continue

                stack.push(last + step)
            }

            memo[last] = false
        }

        return false
    }
}