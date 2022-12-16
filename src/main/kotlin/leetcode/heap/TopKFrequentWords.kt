package leetcode.heap

import java.util.Comparator
import java.util.PriorityQueue

/*
 * https://leetcode.com/problems/top-k-frequent-words/
 */

class TopKFrequentWords {

    fun topKFrequent(words: Array<String>, k: Int): List<String> {

        val map = words.groupingBy { it }.eachCount()

        val comparator = Comparator<Pair<String, Int>> { o1, o2 ->
            val r = o2.second.compareTo(o1.second)
            if (r == 0) o1.first.compareTo(o2.first) else r
        }

        val heap = PriorityQueue<Pair<String, Int>>(comparator)

        map.forEach { (t, u) -> heap.add(Pair(t, u)) }

        val result = mutableListOf<String>()
        var counter = 0

        while (counter < k) {
            result.add(heap.poll().first)
            counter++
        }

        return result
    }
}