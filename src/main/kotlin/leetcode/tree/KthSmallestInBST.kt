package leetcode.tree

import leetcode.TreeNode
import java.util.*

/*
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst
 */

class KthSmallestInBST {

    fun kthSmallest(root: TreeNode?, k: Int): Int {
        val list = LinkedList<Int>()
        inOrder(root, k, list)
        return list.removeLast()
    }

    private fun inOrder(
        root: TreeNode?,
        k: Int,
        list: LinkedList<Int>
    ) {
        if (root == null) return

        inOrder(root.left, k, list)

        if (list.size < k) {
            list.addLast(root.`val`)
        }

        inOrder(root.right, k, list)
    }
}