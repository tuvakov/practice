package leetcode.tree

import leetcode.TreeNode
import kotlin.math.abs

/*
 * https://leetcode.com/problems/balanced-binary-tree
 */

class HeightBalancedBinaryTree {

    fun isBalanced(root: TreeNode?): Boolean {
        if (root == null) return true
        return countHeight(root) !is Result.Error
    }

    private fun countHeight(node: TreeNode?): Result {

        if (node == null) return Result.Success(0)

        val right = countHeight(node.right)
        val left = countHeight(node.left)

        if (right is Result.Error && left is Result.Error) {
            return Result.Error
        }

        val r = right as Result.Success
        val l = left as Result.Success

        val diff = abs(r.height - l.height)

        return if (diff <= 1) {
            Result.Success(maxOf(r.height, l.height) + 1)
        } else {
            Result.Error
        }
    }

    private sealed class Result {
        data class Success(val height: Int) : Result()
        object Error : Result()
    }
}