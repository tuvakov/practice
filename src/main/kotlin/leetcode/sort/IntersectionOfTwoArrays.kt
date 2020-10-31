package leetcode.sort

/*
* Link: https://leetcode.com/problems/intersection-of-two-arrays-ii
*/

class IntersectionOfTwoArrays {
    fun intersectMap(nums1: IntArray, nums2: IntArray): IntArray {
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

    fun intersectSort(nums1: IntArray, nums2: IntArray): IntArray {
        val answer = mutableListOf<Int>()
        nums1.sort()
        nums2.sort()
        var i = 0
        var j = 0
        while (i < nums1.size && j < nums2.size) {
            when {
                nums1[i] == nums2[j] -> {
                    answer.add(nums1[i])
                    ++i
                    ++j
                }
                nums1[i] < nums2[j] -> i++
                else -> j++
            }
        }
        return answer.toIntArray()
    }
}