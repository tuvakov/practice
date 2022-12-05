package leetcode.array

/*
 * Link: https://leetcode.com/problems/find-the-duplicate-number/
 */

class FindTheDuplicateNumber {
    fun findDuplicate(nums: IntArray): Int {
        if (nums.size <= 1) return -1

        var slow = nums[0]
        var fast = nums[slow]
        while (slow != fast) {
            slow = nums[slow]
            fast = nums[nums[fast]]
        }

        fast = 0
        while (fast != slow) {
            fast = nums[fast]
            slow = nums[slow]
        }
        return slow
    }
}