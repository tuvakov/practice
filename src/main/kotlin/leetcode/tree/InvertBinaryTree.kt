package leetcode.tree

import leetcode.TreeNode

class InvertBinaryTree {
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        }
        val right = invertTree(root.right)
        val left = invertTree(root.left)
        root.left = right
        root.right = left
        return root
    }
}