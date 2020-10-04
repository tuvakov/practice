package leetcode.contest.weekly

/*
 * Link: https://leetcode.com/problems/even-odd-tree/
 */

class EvenOddTree {

    fun isEvenOddTree(root: TreeNode?): Boolean {
        val map = mutableMapOf<Int, ArrayList<Int>>()
        traverse(root, map, 0)
        map.forEach { (level, list) ->
            if (!checkLevel(level, list)) return false
        }
        return true
    }

    private fun checkLevel(level: Int, elements: List<Int>): Boolean {

        if (elements.size == 1) {
            val num = elements.first()
            if (level.isEven() && num.isEven()) {
                return false
            } else if (level.isOdd() && num.isOdd()) {
                return false
            }
        }

        for (i in 0 until elements.lastIndex) {
            val first = elements[i]
            val second = elements[i + 1]
            if (level.isEven()) {
                if (first.isEven() || second.isEven() || first >= second)
                    return false

            } else {
                if (first.isOdd() || second.isOdd() || first <= second) {
                    return false
                }
            }
        }
        return true
    }

    private fun traverse(
        node: TreeNode?,
        map: MutableMap<Int, ArrayList<Int>>,
        level: Int
    ) {
        if (node == null) return
        val list = map.getOrDefault(level, ArrayList())
        map[level] = list
        list.add(node.`val`)
        traverse(node.left, map, level + 1)
        traverse(node.right, map, level + 1)
    }

    /**
     * Example:
     * var ti = TreeNode(5)
     * var v = ti.`val`
     * Definition for a binary tree node.
     */
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}

fun Int.isEven(): Boolean {
    return this % 2 == 0
}

fun Int.isOdd(): Boolean {
    return this % 2 != 0
}