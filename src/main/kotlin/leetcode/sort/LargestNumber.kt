package leetcode.sort

/*
 * Link: https://leetcode.com/problems/largest-number/
 */

class LargestNumber {
    fun largestNumber(nums: IntArray): String {
        val ans = nums.map { it.toString() }
            .sortedWith(Comparator { num1, num2 ->
                (num2 + num1).compareTo(num1 + num2)
            }).joinToString("")
        return if (ans.startsWith('0')) "0" else ans
    }
}