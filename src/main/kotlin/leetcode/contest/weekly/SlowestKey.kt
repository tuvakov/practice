package leetcode.contest.weekly

/*
 * Link: https://leetcode.com/problems/slowest-key/
 */

class SlowestKey {
    fun slowestKey(releaseTimes: IntArray, keysPressed: String): Char {
        var prev = 0
        var max = releaseTimes[0]
        var maxIdx = 0

        for (i in 0..releaseTimes.lastIndex) {
            val duration = releaseTimes[i] - prev
            if (duration > max
                || (duration == max && keysPressed[i] > keysPressed[maxIdx])
            ) {
                max = duration
                maxIdx = i
            }
            prev = releaseTimes[i]
        }

        return keysPressed[maxIdx]
    }
}