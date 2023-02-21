package leetcode.greedy

/*
 * https://leetcode.com/problems/container-with-most-water/
 */

class ContainerWithMostWater {
    fun maxArea(heights: IntArray): Int {
        var startIdx = 0
        var endIdx = heights.lastIndex
        var answer = 0

        while (startIdx < endIdx) {

            val height = minOf(heights[startIdx], heights[endIdx])
            val width = endIdx - startIdx
            val area = height * width

            answer = maxOf(answer, area)

            if (heights[startIdx] <= heights[endIdx]) startIdx++
            else endIdx--
        }

        return answer
    }

    fun maxAreaBruteForce(heights: IntArray): Int {
        var answer = 0

        for (idx in 0 until heights.lastIndex) {
            for (jdx in idx + 1..heights.lastIndex) {
                val height = minOf(heights[idx], heights[jdx])
                val width = jdx - idx
                answer = maxOf(answer, height * width)
            }
        }

        return answer
    }
}