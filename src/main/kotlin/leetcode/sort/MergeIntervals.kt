package leetcode.sort

/*
 * https://leetcode.com/problems/merge-intervals/
 */
class MergeIntervals {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortBy { it[0] }
        val result = mutableListOf<IntArray>()

        var start = intervals[0][0]
        var end = intervals[0][1]

        for ((currStart, currEnd) in intervals) {
            if (currStart <= end) {
                end = maxOf(end, currEnd)
                continue
            }
            result.add(intArrayOf(start, end))
            start = currStart
            end = currEnd
        }

        result.add(intArrayOf(start, end))

        return result.toTypedArray()
    }
}