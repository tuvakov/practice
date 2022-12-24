package leetcode.array

/*
 * https://leetcode.com/problems/majority-element/description/
 */

class MajorityElement {

    fun majorityElementSort(nums: IntArray): Int {
        nums.sort()
        return nums[nums.size / 2]
    }

    fun majorityElementHashTable(nums: IntArray): Int {
        val map = mutableMapOf<Int, Int>()
        var maxCount = 0
        var majority = 0

        for (num in nums) {
            val count = map.getOrDefault(num, 0)
            map[num] = count + 1
            if (count + 1 > maxCount) {
                maxCount = count
                majority = num
            }
        }

        return majority
    }

    fun majorityElementBoyerMoore(nums: IntArray): Int {
        var count = 0
        var majority = 0

        for (num in nums) {
            if (count == 0) majority = num
            count += if (majority == num) 1 else -1
        }

        return majority
    }
}