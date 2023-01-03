package leetcode.array

/*
 * https://leetcode.com/problems/merge-sorted-array/
 */

class MergeSortedArrays {
    fun merge(
        nums1: IntArray,
        m: Int,
        nums2: IntArray,
        n: Int
    ) {

        var idx = m - 1
        var jdx = n - 1
        var kdx = nums1.lastIndex

        while (idx >= 0 && jdx >= 0) {
            nums1[kdx--] =
                if (nums1[idx] > nums2[jdx]) nums1[idx--] else nums2[jdx--]
        }

        while (jdx >= 0) nums1[kdx--] = nums2[jdx--]
    }
}