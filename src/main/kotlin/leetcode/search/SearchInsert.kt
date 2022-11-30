package leetcode.search

/*
 * https://leetcode.com/problems/search-insert-position
 */

class SearchInsert {

    fun searchInsert(nums: IntArray, target: Int): Int {
        var start = 0
        var end = nums.lastIndex

        while (start <= end) {
            val middle = start + (end - start) / 2
            when {
                target < nums[middle] -> end = middle - 1
                target > nums[middle] -> start = middle + 1
                else -> return middle
            }
        }

        return start
    }
}