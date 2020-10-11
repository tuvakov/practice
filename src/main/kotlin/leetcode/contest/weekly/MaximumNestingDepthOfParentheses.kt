package leetcode.contest.weekly

/*
 * Link: https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/
 */

class MaximumNestingDepthOfParentheses {
    fun maxDepth(s: String): Int {
        var answer = 0
        var nested = 0
        for (char in s.toCharArray()) {
            when (char) {
                '(' -> {
                    ++nested
                }
                ')' -> {
                    answer = maxOf(answer, nested)
                    --nested
                }
            }
        }
        return answer;
    }

}