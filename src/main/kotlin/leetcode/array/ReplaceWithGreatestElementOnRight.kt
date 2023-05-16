package leetcode.array

/*
 * https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/
 */

class ReplaceWithGreatestElementOnRight {
    fun replaceElements(arr: IntArray): IntArray {
        val answer = IntArray(arr.size) { -1 }

        for (idx in arr.lastIndex - 1 downTo 0) {
            answer[idx] = maxOf(arr[idx + 1], answer[idx + 1])
        }

        return answer
    }
}