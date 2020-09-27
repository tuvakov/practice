package leetcode

/*
 *
 * Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *
 * Both works fine.
 */

class RemoveDuplicatesInSortedArray {
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }
        var position = 0
        for (i in 0..nums.lastIndex) {
            if (i == 0 || nums[i] != nums[i - 1])
                nums[position++] = nums[i]
        }
        return position
    }

    fun removeDuplicates2(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        var length = 0
        var left = 0
        var right = 1
        var position = 0
        while (right <= nums.lastIndex) {
            if (nums[left] != nums[right]) {
                nums[position++] = nums[left]
                length++
                left = right
            }
            right++
        }
        nums[position] = nums[right - 1]
        return length + 1
    }
}