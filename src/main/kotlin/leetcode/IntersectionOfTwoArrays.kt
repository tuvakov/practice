package leetcode

/*
* Link: https://leetcode.com/problems/intersection-of-two-arrays-ii
*/

class IntersectionOfTwoArrays {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val map1 = nums1.toList().groupingBy { it }.eachCount()
        val map2 = nums2.toList().groupingBy { it }.eachCount()
        val answer = mutableListOf<Int>()
        for (entry in map1) {
            map2[entry.key]?.let {
                val count = if (entry.value < it) entry.value else it
                for (i in 0 until count) answer.add(entry.key)
            }
        }
        return answer.toIntArray()
    }
}