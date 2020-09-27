package leetcode

/*
 * Link: https://leetcode.com/problems/sort-colors/
 *
 * a.k.a National Dutch flag question
 */

class SortColors {
    fun sortColors(nums: IntArray) {
        var pointer = 0
        for (i in 0..nums.lastIndex) {
            if (nums[i] == 0) {
                swap(nums, pointer, i)
                pointer++
            }
        }
        for (i in pointer..nums.lastIndex) {
            if (nums[i] == 1) {
                swap(nums, pointer, i)
                pointer++
            }
        }
    }

    fun sortColorsOnePath(nums: IntArray) {
        var smaller = 0
        var eq = 0
        var larger = nums.lastIndex

        while (eq <= larger) {
            when {
                nums[eq] == 0 -> {
                    swap(nums, smaller, eq)
                    ++smaller
                    ++eq
                }
                nums[eq] == 2 -> {
                    swap(nums, larger, eq)
                    --larger
                }
                else -> {
                    ++eq
                }
            }
        }
    }

    private fun swap(nums: IntArray, firstIdx: Int, secondIdx: Int) {
        val temp = nums[firstIdx];
        nums[firstIdx] = nums[secondIdx]
        nums[secondIdx] = temp
    }
}