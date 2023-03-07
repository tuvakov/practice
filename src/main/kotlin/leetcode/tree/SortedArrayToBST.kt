package leetcode.tree

import leetcode.TreeNode

/*
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree
 */

class SortedArrayToBST {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        return construct(nums, 0, nums.lastIndex)
    }

    private fun construct(
        nums: IntArray,
        start: Int,
        end: Int
    ): TreeNode? {

        if (end < start) return null

        val middle = (start + end) / 2

        val node = TreeNode(nums[middle])

        node.left = construct(nums, start, middle - 1)
        node.right = construct(nums, middle + 1, end)

        return node
    }
}