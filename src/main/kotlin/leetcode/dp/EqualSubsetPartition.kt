package leetcode.dp

/*
 * https://leetcode.com/problems/partition-equal-subset-sum/
 */

class EqualSubsetPartition {
    fun canPartition(nums: IntArray): Boolean {
        val sum = nums.sum()
        if (sum % 2 != 0) return false
        val memo = mutableMapOf<String, Boolean>()
        return canPartition(
            nums,
            memo,
            startIdx = 0,
            current = nums[0],
            target = sum / 2
        )
    }

    private fun canPartition(
        nums: IntArray,
        memo: MutableMap<String, Boolean>,
        startIdx: Int,
        current: Int,
        target: Int
    ): Boolean {
        if (startIdx > nums.lastIndex) return false

        if (current == target) return true

        for (idx in startIdx + 1..nums.lastIndex) {

            val key = "$idx-$current"
            if (key in memo) return memo[key]!!

            val temp = current + nums[idx]
            val result = if (temp <= target) {
                canPartition(nums, memo, idx, temp, target)
            } else {
                canPartition(nums, memo, idx, current, target)
            }

            memo[key] = result

            if (result) return true
        }

        return false
    }

    fun canPartition2(nums: IntArray): Boolean {
        val sum = nums.sum()
        if (sum % 2 != 0) return false
        val half = sum / 2

        val sums = mutableSetOf<Int>()
        sums.add(0)

        for (num in nums) {
            val tempSums = mutableSetOf<Int>()
            for (s in sums) {
                tempSums.add(s + num)
            }
            sums.addAll(tempSums)
            if (half in sums) return true
        }

        return false
    }
}