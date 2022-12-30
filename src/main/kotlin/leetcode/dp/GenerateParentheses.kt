package leetcode.dp

/*
 * https://leetcode.com/problems/generate-parentheses/
 */

class GenerateParentheses {

    fun generateParenthesis(n: Int): List<String> {
        val result = mutableListOf<String>()
        generateParenthesis(n, n, "", result)
        return result
    }

    private fun generateParenthesis(
        opened: Int,
        closed: Int,
        current: String,
        result: MutableList<String>
    ) {
        if (opened == 0 && closed == 0) {
            result.add(current)
            return
        }

        if (opened > 0)
            generateParenthesis(opened - 1, closed, "$current(", result)

        if (opened < closed)
            generateParenthesis(opened, closed - 1, "$current)", result)
    }
}