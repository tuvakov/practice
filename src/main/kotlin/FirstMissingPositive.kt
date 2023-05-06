import kotlin.math.abs

class FirstMissingPositive {
    fun firstMissingPositive(nums: IntArray): Int {
        nums.sort()
        var missing = 1
        for (num in nums) {
            if (num <= 0) continue
            if (missing < num) return missing
            missing = num + 1
        }
        return missing
    }

    fun firstMissingPositive2(nums: IntArray): Int {

        for (idx in nums.indices) {
            if (nums[idx] < 0) nums[idx] = 0
        }

        for (idx in nums.indices) {
            val num = abs(nums[idx])
            if (num !in 1..nums.size) continue
            if (nums[num - 1] > 0) nums[num - 1] = nums[num - 1] * -1
            else if (nums[num - 1] == 0) nums[num - 1] = (nums.size + 1) * -1
        }

        for (idx in nums.indices) {
            if (nums[idx] >= 0) return idx + 1
        }

        return nums.size + 1
    }
}