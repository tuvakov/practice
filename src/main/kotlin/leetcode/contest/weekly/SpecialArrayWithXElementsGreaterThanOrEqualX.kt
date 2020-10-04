package leetcode.contest.weekly

/*
 * Link: https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/
 */

class SpecialArrayWithXElementsGreaterThanOrEqualX {
    fun specialArray(nums: IntArray): Int {
        nums.sort()
        val start = if (nums.first() > 0) nums.first() - 1 else nums.first()
        val end = nums.last()
        for (x in start..end) {
            val idx = findFirstOccurrence(nums, x)
            val rem = nums.size - idx
            if (rem == x) return x
        }
        return -1
    }

    private fun findFirstOccurrence(arr: IntArray, x: Int): Int {

        var start = 0
        var end = arr.lastIndex
        var result = -1

        while (start <= end) {
            val middle: Int = start + (end - start) / 2
            when {
                x > arr[middle] -> start = middle + 1
                x < arr[middle] -> end = middle - 1
                else -> {
                    result = middle
                    end = middle - 1
                }
            }
        }
        return if (result == -1) (end + 1) else result
    }
}