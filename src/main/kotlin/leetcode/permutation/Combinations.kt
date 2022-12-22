package leetcode.permutation

import java.util.LinkedList

/*
 * https://leetcode.com/problems/combinations/
 */
class Combinations {

    fun combine(n: Int, k: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        repeat(n) {
            combine(n, k, it + 1, LinkedList(), result)
        }
        return result
    }

    private fun combine(
        n: Int,
        k: Int,
        current: Int,
        temp: LinkedList<Int>,
        result: MutableList<List<Int>>
    ) {

        if (current > n) return

        temp.add(current)

        if (temp.size == k) {
            result.add(temp)
            return
        }

        for (i in current + 1..n) {
            val copy = LinkedList(temp)
            combine(n, k, i, copy, result)
        }
    }
}
