package leetcode.contest.weekly

/*
 * Link: https://leetcode.com/problems/arithmetic-subarrays/
 */

class ArithmeticSubarrays {
    fun checkArithmeticSubarrays(
        nums: IntArray,
        left: IntArray,
        right: IntArray
    ): List<Boolean> {
        val answer = mutableListOf<Boolean>()
        for (i in 0..left.lastIndex) {
            val sub = nums.copyOfRange(left[i], right[i] + 1).apply { sort() }
            answer.add(isArithmetic(sub))
        }
        return answer
    }

    private fun isArithmetic(arr: IntArray): Boolean {
        if (arr.size < 2) return false
        val diff = arr[0] - arr[1]
        for (j in 0 until arr.lastIndex) {
            if (arr[j] - arr[j + 1] != diff) return false
        }
        return true
    }
}