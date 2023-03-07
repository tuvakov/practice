package leetcode.tree

import leetcode.TreeNode

/*
 * https://leetcode.com/problems/binary-tree-right-side-view
 */

class RightSideView {
    fun rightSideView(root: TreeNode?): List<Int> {
        val list = mutableListOf<Int>()
        rightSideView(root, 0, list)
        return list
    }

    private fun rightSideView(
        node: TreeNode?,
        level: Int,
        list: MutableList<Int>
    ) {
        if (node == null) return

        if (level !in list.indices) list.add(node.`val`)
        else list[level] = node.`val`

        rightSideView(node.left, level + 1, list)
        rightSideView(node.right, level + 1, list)
    }
}