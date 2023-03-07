package leetcode.tree

import leetcode.TreeNode

/*
 * https://leetcode.com/problems/same-tree
 */

class SameBinaryTree {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) return true
        if (p?.`val` != q?.`val`) return false
        val result = isSameTree(p?.right, q?.right)
        if (!result) return false
        return isSameTree(p?.left, q?.left)
    }
}