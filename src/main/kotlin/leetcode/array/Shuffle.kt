package leetcode.array

import java.util.Random

/*
 * https://leetcode.com/problems/shuffle-an-array/
 */

class Shuffle(private val nums: IntArray) {

    private val original = nums.copyOf()
    fun reset(): IntArray {
        return original
    }

    fun shuffle(): IntArray {
        val random = Random()
        for (idx in nums.lastIndex downTo 0) {
            val randIdx = random.nextInt(idx + 1)
            swap(idx, randIdx)
        }
        return nums
    }

    private fun swap(i: Int, j: Int) {
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }
}